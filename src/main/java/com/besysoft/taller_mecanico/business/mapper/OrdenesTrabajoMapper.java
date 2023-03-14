package com.besysoft.taller_mecanico.business.mapper;

import com.besysoft.taller_mecanico.business.dto.OrdenesTrabajoDto;
import com.besysoft.taller_mecanico.domain.entity.OrdenesTrabajo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrdenesTrabajoMapper {
    OrdenesTrabajo toEntity(OrdenesTrabajoDto ordenesTrabajoDto);

    OrdenesTrabajoDto toDto(OrdenesTrabajo ordenesTrabajo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrdenesTrabajo partialUpdate(OrdenesTrabajoDto ordenesTrabajoDto, @MappingTarget OrdenesTrabajo ordenesTrabajo);
}