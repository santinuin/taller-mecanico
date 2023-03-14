package com.besysoft.taller_mecanico.business.mapper;

import com.besysoft.taller_mecanico.business.dto.EmpleadoDto;
import com.besysoft.taller_mecanico.domain.entity.Empleado;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmpleadoMapper {
    Empleado toEntity(EmpleadoDto empleadoDto);

    EmpleadoDto toDto(Empleado empleado);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Empleado partialUpdate(EmpleadoDto empleadoDto, @MappingTarget Empleado empleado);
}