package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.business.mapper.ClienteMapper;
import com.besysoft.taller_mecanico.domain.entity.Cliente;
import com.besysoft.taller_mecanico.domain.entity.Empleado;
import com.besysoft.taller_mecanico.domain.entity.Vehiculo;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;
import com.besysoft.taller_mecanico.repository.ClienteRepository;
import com.besysoft.taller_mecanico.repository.EmpleadoRepository;
import com.besysoft.taller_mecanico.repository.VehiculoRepository;
import com.besysoft.taller_mecanico.service.interfaces.EmpleadoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final ClienteRepository clienteRepository;
    private final VehiculoRepository vehiculoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository, ClienteRepository clienteRepository, VehiculoRepository vehiculoRepository, ClienteMapper clienteMapper) {
        this.empleadoRepository = empleadoRepository;
        this.clienteRepository = clienteRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    @Transactional
    public void recibirClienteYVehiculo(Long empleadoId, Cliente cliente) throws InvalidRolException {

        Vehiculo vehiculo = cliente.getVehiculos().get(0);

        Empleado empleado = this.empleadoRepository.findById(empleadoId).orElseThrow();

        if (!Objects.equals(empleado.getTipoEmpleado(), "RECEPCIONISTA")) {
            throw new InvalidRolException("Error: debe ser recepcionista para realizar esta acción");
        }

        Vehiculo vehiculoExistente = this.vehiculoRepository.findByPatente(vehiculo.getPatente());
        Cliente clienteExistente = this.clienteRepository.findByCorreoElectronico(cliente.getCorreoElectronico());

        if (vehiculoExistente != null) {
            if (clienteExistente != null) {
                clienteExistente.setVehiculos(List.of(vehiculoExistente));
                return;
            }
            cliente.setVehiculos(List.of(vehiculoExistente));
            clienteRepository.save(cliente);
            return;
        }

        if (clienteExistente != null) {
            clienteExistente.setVehiculos(List.of(vehiculo));
            return;
        }

        clienteRepository.save(cliente);
    }

}
