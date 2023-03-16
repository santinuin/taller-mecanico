package com.besysoft.taller_mecanico.business.mapper.interfaces;

import com.besysoft.taller_mecanico.business.dto.RepuestoDto;
import com.besysoft.taller_mecanico.domain.entity.Repuesto;
import org.mapstruct.*;

public interface RepuestoMapper {
    Repuesto toEntity(RepuestoDto repuestoDto);

    RepuestoDto toDto(Repuesto repuesto);

    Repuesto partialUpdate(RepuestoDto repuestoDto, @MappingTarget Repuesto repuesto);
}