package com.besysoft.taller_mecanico.business.mapper.interfaces;

import com.besysoft.taller_mecanico.business.dto.FormaPagoDto;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;

public interface FormaPagoMapper {
    OrdenTrabajo toEntity(FormaPagoDto formaPagoDto);

    FormaPagoDto toDto(OrdenTrabajo ordenTrabajo);

    OrdenTrabajo partialUpdate(FormaPagoDto formaPagoDto, OrdenTrabajo ordenTrabajo);
}