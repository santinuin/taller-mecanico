package com.besysoft.taller_mecanico.business.mapper;

import com.besysoft.taller_mecanico.business.dto.MecanicoDto;
import com.besysoft.taller_mecanico.domain.entity.Mecanico;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MecanicoMapper {
    Mecanico toEntity(MecanicoDto mecanicoDto);

    MecanicoDto toDto(Mecanico mecanico);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Mecanico partialUpdate(MecanicoDto mecanicoDto, @MappingTarget Mecanico mecanico);
}