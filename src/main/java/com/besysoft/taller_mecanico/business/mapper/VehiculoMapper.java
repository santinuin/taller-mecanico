package com.besysoft.taller_mecanico.business.mapper;

import com.besysoft.taller_mecanico.business.dto.VehiculoDto;
import com.besysoft.taller_mecanico.domain.entity.Vehiculo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehiculoMapper {
    Vehiculo toEntity(VehiculoDto vehiculoDto);

    VehiculoDto toDto(Vehiculo vehiculo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Vehiculo partialUpdate(VehiculoDto vehiculoDto, @MappingTarget Vehiculo vehiculo);
}