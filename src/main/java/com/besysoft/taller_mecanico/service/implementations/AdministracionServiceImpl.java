package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.domain.entity.Empleado;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.domain.enumerations.EstadoOrdenEnum;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;
import com.besysoft.taller_mecanico.repository.EmpleadoRepository;
import com.besysoft.taller_mecanico.repository.OrdenTrabajoRepository;
import com.besysoft.taller_mecanico.service.interfaces.AdministracionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

import static com.besysoft.taller_mecanico.domain.enumerations.TipoEmpleadoEnum.ADMINISTRATIVO;

@Service
public class AdministracionServiceImpl implements AdministracionService {

    private final OrdenTrabajoRepository ordenTrabajoRepository;
    private final EmpleadoRepository empleadoRepository;

    public AdministracionServiceImpl(OrdenTrabajoRepository ordenTrabajoRepository, EmpleadoRepository empleadoRepository) {
        this.ordenTrabajoRepository = ordenTrabajoRepository;
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    @Transactional
    public void facturar(Long empleadoId, OrdenTrabajo ordenTrabajo) throws InvalidRolException {

        Empleado empleado = this.empleadoRepository.findById(empleadoId).orElseThrow();

        if (!Objects.equals(empleado.getTipoEmpleado(), ADMINISTRATIVO)) {
            throw new InvalidRolException("Error: debe ser administrativo para realizar esta acción");
        }

        ordenTrabajo.setFechaPago(LocalDateTime.now());
        ordenTrabajo.setEstado(EstadoOrdenEnum.FACTURADA);
        ordenTrabajo.setAdministrativo(this.empleadoRepository.findById(empleadoId).orElseThrow());

        this.ordenTrabajoRepository.save(ordenTrabajo);

    }
}
