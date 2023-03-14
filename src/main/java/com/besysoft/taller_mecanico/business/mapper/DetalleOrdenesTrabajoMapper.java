package com.besysoft.taller_mecanico.business.mapper;

import com.besysoft.taller_mecanico.business.dto.DetalleOrdenesTrabajoDto;
import com.besysoft.taller_mecanico.domain.entity.DetalleOrdenesTrabajo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DetalleOrdenesTrabajoMapper {
    DetalleOrdenesTrabajo toEntity(DetalleOrdenesTrabajoDto detalleOrdenesTrabajoDto);

    DetalleOrdenesTrabajoDto toDto(DetalleOrdenesTrabajo detalleOrdenesTrabajo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DetalleOrdenesTrabajo partialUpdate(DetalleOrdenesTrabajoDto detalleOrdenesTrabajoDto, @MappingTarget DetalleOrdenesTrabajo detalleOrdenesTrabajo);
}