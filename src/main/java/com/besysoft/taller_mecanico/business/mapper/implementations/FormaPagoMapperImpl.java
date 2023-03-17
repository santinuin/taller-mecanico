package com.besysoft.taller_mecanico.business.mapper.implementations;

import com.besysoft.taller_mecanico.business.dto.FormaPagoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.FormaPagoMapper;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.service.interfaces.OrdenTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class FormaPagoMapperImpl implements FormaPagoMapper {

    @Autowired
    private OrdenTrabajoService ordenTrabajoService;

    @Override
    public OrdenTrabajo toEntity(FormaPagoDto formaPagoDto) {
        if (formaPagoDto == null) {
            return null;
        }

        OrdenTrabajo ordenTrabajo = this.ordenTrabajoService.findById(formaPagoDto.getId()).orElseThrow();
        ordenTrabajo.setCantidadCuotas(formaPagoDto.getCantidadCuotas());
        ordenTrabajo.setFormaPago(formaPagoDto.getFormaPago());
        ordenTrabajo.setImporteTotal(formaPagoDto.getImporteTotal());
        ordenTrabajo.setTipoTarjeta(formaPagoDto.getFormaPago());

        return ordenTrabajo;
    }

    @Override
    public FormaPagoDto toDto(OrdenTrabajo ordenTrabajo) {
        if (ordenTrabajo == null) {
            return null;
        }

        FormaPagoDto formaPagoDto = new FormaPagoDto();

        formaPagoDto.setId(ordenTrabajo.getId());
        formaPagoDto.setCantidadCuotas(ordenTrabajo.getCantidadCuotas());
        formaPagoDto.setFechaPago(ordenTrabajo.getFechaPago());
        formaPagoDto.setFormaPago(ordenTrabajo.getFormaPago());
        formaPagoDto.setImporteTotal(ordenTrabajo.getImporteTotal());
        formaPagoDto.setTipoTarjeta(ordenTrabajo.getTipoTarjeta());

        return formaPagoDto;
    }

    @Override
    public OrdenTrabajo partialUpdate(FormaPagoDto formaPagoDto, OrdenTrabajo ordenTrabajo) {
        if (formaPagoDto == null) {
            return ordenTrabajo;
        }

        if (formaPagoDto.getId() != null) {
            ordenTrabajo.setId(formaPagoDto.getId());
        }
        if (formaPagoDto.getCantidadCuotas() != null) {
            ordenTrabajo.setCantidadCuotas(formaPagoDto.getCantidadCuotas());
        }
        if (formaPagoDto.getFechaPago() != null) {
            ordenTrabajo.setFechaPago(formaPagoDto.getFechaPago());
        }
        if (formaPagoDto.getFormaPago() != null) {
            ordenTrabajo.setFormaPago(formaPagoDto.getFormaPago());
        }
        if (formaPagoDto.getImporteTotal() != null) {
            ordenTrabajo.setImporteTotal(formaPagoDto.getImporteTotal());
        }
        if (formaPagoDto.getTipoTarjeta() != null) {
            ordenTrabajo.setTipoTarjeta(formaPagoDto.getTipoTarjeta());
        }

        return ordenTrabajo;
    }
}