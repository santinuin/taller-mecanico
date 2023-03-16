package com.besysoft.taller_mecanico.business.mapper.interfaces;

import com.besysoft.taller_mecanico.business.dto.ManoObraDto;
import com.besysoft.taller_mecanico.domain.entity.ManoObra;

public interface ManoObraMapper {
    ManoObra toEntity(ManoObraDto manoObraDto);

    ManoObraDto toDto(ManoObra manoObra);
}