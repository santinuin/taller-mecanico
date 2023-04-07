package com.besysoft.taller_mecanico.business.mapper.interfaces;

import com.besysoft.taller_mecanico.business.dto.MecanicoDto;
import com.besysoft.taller_mecanico.domain.entity.Mecanico;

public interface MecanicoMapper {
    Mecanico toEntity(MecanicoDto mecanicoDto);

    MecanicoDto toDto(Mecanico mecanico);

    Mecanico partialUpdate(MecanicoDto mecanicoDto, Mecanico mecanico);
}