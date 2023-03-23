package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.business.mapper.interfaces.ClienteMapper;
import com.besysoft.taller_mecanico.domain.entity.*;
import com.besysoft.taller_mecanico.domain.enumerations.EstadoOrdenEnum;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;
import com.besysoft.taller_mecanico.repository.*;
import com.besysoft.taller_mecanico.service.interfaces.RecepcionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static com.besysoft.taller_mecanico.domain.enumerations.EstadoOrdenEnum.CREADA;
import static com.besysoft.taller_mecanico.domain.enumerations.TipoEmpleadoEnum.RECEPCIONISTA;

@Service
public class RecepcionServiceImpl implements RecepcionService {

    private final EmpleadoRepository empleadoRepository;
    private final ClienteRepository clienteRepository;
    private final VehiculoRepository vehiculoRepository;
    private final OrdenTrabajoRepository ordenTrabajoRepository;
    private final MecanicoRepository mecanicoRepository;
    private final ManoObraRepository manoObraRepository;

    public RecepcionServiceImpl(EmpleadoRepository empleadoRepository, ClienteRepository clienteRepository, VehiculoRepository vehiculoRepository, ClienteMapper clienteMapper, OrdenTrabajoRepository ordenTrabajoRepository, MecanicoRepository mecanicoRepository, ManoObraRepository manoObraRepository) {
        this.empleadoRepository = empleadoRepository;
        this.clienteRepository = clienteRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.ordenTrabajoRepository = ordenTrabajoRepository;
        this.mecanicoRepository = mecanicoRepository;
        this.manoObraRepository = manoObraRepository;
    }

    @Override
    @Transactional
    public void recibirClienteYVehiculo(Long empleadoId, Cliente cliente) throws InvalidRolException {

        Vehiculo vehiculo = cliente.getVehiculos().get(0);

        Empleado empleado = this.empleadoRepository.findById(empleadoId).orElseThrow();

        if (!Objects.equals(empleado.getTipoEmpleado(), RECEPCIONISTA)) {
            throw new InvalidRolException("Error: debe ser recepcionista para realizar esta acción");
        }

        Vehiculo vehiculoExistente = this.vehiculoRepository.findByPatente(vehiculo.getPatente());
        Cliente clienteExistente = this.clienteRepository.findByCorreoElectronico(cliente.getCorreoElectronico());

        if (vehiculoExistente != null) {
            if (clienteExistente != null) {
                clienteExistente.getVehiculos().add(vehiculoExistente);
                return;
            }
            cliente.setVehiculos(List.of(vehiculoExistente));
            clienteRepository.save(cliente);
            return;
        }

        if (clienteExistente != null) {
            clienteExistente.getVehiculos().add(vehiculo);
            return;
        }

        clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void generarOrdenDeTrabajo(Long empleadoId,
                                      String nivelCombustible,
                                      Long kilometraje,
                                      String detalleFalla,
                                      String patenteVehiculo,
                                      Long mecanicoId) throws InvalidRolException {

        Empleado empleado = this.empleadoRepository.findById(empleadoId).orElseThrow();

        if (!Objects.equals(empleado.getTipoEmpleado(), RECEPCIONISTA)) {
            throw new InvalidRolException("Error: debe ser recepcionista para realizar esta acción");
        }

        OrdenTrabajo ordenTrabajo = new OrdenTrabajo();

        ordenTrabajo.setFechaIngreso(LocalDateTime.now());
        ordenTrabajo.setRecepcionista(empleado);
        ordenTrabajo.setNivelCombustible(nivelCombustible);
        ordenTrabajo.setKilometraje(kilometraje);
        ordenTrabajo.setDetalleFalla(detalleFalla);
        ordenTrabajo.setVehiculo(vehiculoRepository.findByPatente(patenteVehiculo));
        ordenTrabajo.setEstado(CREADA);

        this.ordenTrabajoRepository.save(ordenTrabajo);

        ManoObra manoObra = new ManoObra();

        manoObra.setOrdenTrabajo(ordenTrabajo);
        manoObra.setMecanico(mecanicoRepository.findById(mecanicoId).orElse(null));

        this.manoObraRepository.save(manoObra);
    }

    @Override
    @Transactional
    public void entregarVehiculo(Long empleadoId, Long ordenTrabajoId) throws InvalidRolException {

        Empleado empleado = this.empleadoRepository.findById(empleadoId).orElseThrow();

        if (!Objects.equals(empleado.getTipoEmpleado(), RECEPCIONISTA)) {
            throw new InvalidRolException("Error: debe ser recepcionista para realizar esta acción");
        }

        OrdenTrabajo ordenTrabajo = this.ordenTrabajoRepository.findById(ordenTrabajoId).orElseThrow();

        ordenTrabajo.setEstado(EstadoOrdenEnum.CERRADA);

        this.ordenTrabajoRepository.save(ordenTrabajo);
    }

}
