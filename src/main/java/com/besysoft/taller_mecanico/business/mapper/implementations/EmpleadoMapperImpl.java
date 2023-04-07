package com.besysoft.taller_mecanico.business.mapper.implementations;

import com.besysoft.taller_mecanico.business.dto.EmpleadoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.EmpleadoMapper;
import com.besysoft.taller_mecanico.domain.entity.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapperImpl implements EmpleadoMapper {

    @Override
    public Empleado toEntity(EmpleadoDto empleadoDto) {
        if (empleadoDto == null) {
            return null;
        }

        Empleado empleado = new Empleado();

        empleado.setId(empleadoDto.getId());
        empleado.setApellido(empleadoDto.getApellido());
        empleado.setCelular(empleadoDto.getCelular());
        empleado.setCalle(empleadoDto.getCalle());
        empleado.setCodigoPostal(empleadoDto.getCodigoPostal());
        empleado.setDepartamento(empleadoDto.getDepartamento());
        empleado.setLocalidad(empleadoDto.getLocalidad());
        empleado.setNumero(empleadoDto.getNumero());
        empleado.setPiso(empleadoDto.getPiso());
        empleado.setNombres(empleadoDto.getNombres());
        empleado.setTipoEmpleado(empleadoDto.getTipoEmpleado());

        return empleado;
    }

    @Override
    public EmpleadoDto toDto(Empleado empleado) {
        if (empleado == null) {
            return null;
        }

        EmpleadoDto empleadoDto = new EmpleadoDto();

        empleadoDto.setId(empleado.getId());
        empleadoDto.setApellido(empleado.getApellido());
        empleadoDto.setCelular(empleado.getCelular());
        empleadoDto.setCalle(empleado.getCalle());
        empleadoDto.setCodigoPostal(empleado.getCodigoPostal());
        empleadoDto.setDepartamento(empleado.getDepartamento());
        empleadoDto.setLocalidad(empleado.getLocalidad());
        empleadoDto.setNumero(empleado.getNumero());
        empleadoDto.setPiso(empleado.getPiso());
        empleadoDto.setNombres(empleado.getNombres());
        empleadoDto.setTipoEmpleado(empleado.getTipoEmpleado());

        return empleadoDto;
    }

    @Override
    public Empleado partialUpdate(EmpleadoDto empleadoDto, Empleado empleado) {
        if (empleadoDto == null) {
            return empleado;
        }

        if (empleadoDto.getId() != null) {
            empleado.setId(empleadoDto.getId());
        }
        if (empleadoDto.getApellido() != null) {
            empleado.setApellido(empleadoDto.getApellido());
        }
        if (empleadoDto.getCelular() != null) {
            empleado.setCelular(empleadoDto.getCelular());
        }
        if (empleadoDto.getCalle() != null) {
            empleado.setCalle(empleadoDto.getCalle());
        }
        if (empleadoDto.getCodigoPostal() != null) {
            empleado.setCodigoPostal(empleadoDto.getCodigoPostal());
        }
        if (empleadoDto.getDepartamento() != null) {
            empleado.setDepartamento(empleadoDto.getDepartamento());
        }
        if (empleadoDto.getLocalidad() != null) {
            empleado.setLocalidad(empleadoDto.getLocalidad());
        }
        if (empleadoDto.getNumero() != null) {
            empleado.setNumero(empleadoDto.getNumero());
        }
        if (empleadoDto.getPiso() != null) {
            empleado.setPiso(empleadoDto.getPiso());
        }
        if (empleadoDto.getNombres() != null) {
            empleado.setNombres(empleadoDto.getNombres());
        }
        if (empleadoDto.getTipoEmpleado() != null) {
            empleado.setTipoEmpleado(empleadoDto.getTipoEmpleado());
        }

        return empleado;
    }
}
