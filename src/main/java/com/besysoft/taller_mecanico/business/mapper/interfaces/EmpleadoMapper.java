package com.besysoft.taller_mecanico.business.mapper.interfaces;

import com.besysoft.taller_mecanico.business.dto.EmpleadoDto;
import com.besysoft.taller_mecanico.domain.entity.Empleado;

public interface EmpleadoMapper {
    Empleado toEntity(EmpleadoDto empleadoDto);

    EmpleadoDto toDto(Empleado empleado);

    Empleado partialUpdate(EmpleadoDto empleadoDto, Empleado empleado);
}