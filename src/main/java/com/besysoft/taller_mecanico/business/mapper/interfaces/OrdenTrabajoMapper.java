package com.besysoft.taller_mecanico.business.mapper.interfaces;

import com.besysoft.taller_mecanico.business.dto.OrdenTrabajoDto;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;

public interface OrdenTrabajoMapper {
    OrdenTrabajo toEntity(OrdenTrabajoDto ordenTrabajoDto);

    OrdenTrabajoDto toDto(OrdenTrabajo ordenTrabajo);
}