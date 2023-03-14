package com.besysoft.taller_mecanico.business.mapper;

import com.besysoft.taller_mecanico.business.dto.ManoObraDto;
import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ManoObraMapper {
    ManoObra toEntity(ManoObraDto manoObraDto);

    ManoObraDto toDto(ManoObra manoObra);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ManoObra partialUpdate(ManoObraDto manoObraDto, @MappingTarget ManoObra manoObra);
}