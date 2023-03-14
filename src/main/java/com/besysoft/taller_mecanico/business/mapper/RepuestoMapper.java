package com.besysoft.taller_mecanico.business.mapper;

import com.besysoft.taller_mecanico.business.dto.RepuestoDto;
import com.besysoft.taller_mecanico.domain.entity.Repuesto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RepuestoMapper {
    Repuesto toEntity(RepuestoDto repuestoDto);

    RepuestoDto toDto(Repuesto repuesto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Repuesto partialUpdate(RepuestoDto repuestoDto, @MappingTarget Repuesto repuesto);
}