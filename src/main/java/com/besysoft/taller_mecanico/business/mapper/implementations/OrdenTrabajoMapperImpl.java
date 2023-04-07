package com.besysoft.taller_mecanico.business.mapper.implementations;

import com.besysoft.taller_mecanico.business.dto.OrdenTrabajoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.OrdenTrabajoMapper;
import com.besysoft.taller_mecanico.business.mapper.interfaces.VehiculoMapper;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.service.interfaces.ManoObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdenTrabajoMapperImpl implements OrdenTrabajoMapper {

    @Autowired
    private VehiculoMapper vehiculoMapper;

    @Autowired
    private ManoObraService manoObraService;

    @Override
    public OrdenTrabajo toEntity(OrdenTrabajoDto ordenTrabajoDto) {
        if (ordenTrabajoDto == null) {
            return null;
        }

        OrdenTrabajo ordenTrabajo = new OrdenTrabajo();

        ordenTrabajo.setId(ordenTrabajoDto.getId());
        ordenTrabajo.setCantidadCuotas(ordenTrabajoDto.getCantidadCuotas());
        ordenTrabajo.setDetalleFalla(ordenTrabajoDto.getDetalleFalla());
        ordenTrabajo.setEstado(ordenTrabajoDto.getEstado());
        ordenTrabajo.setFechaFinReparacion(ordenTrabajoDto.getFechaFinReparacion());
        ordenTrabajo.setFechaIngreso(ordenTrabajoDto.getFechaIngreso());
        ordenTrabajo.setFechaPago(ordenTrabajoDto.getFechaPago());
        ordenTrabajo.setFormaPago(ordenTrabajoDto.getFormaPago());
        ordenTrabajo.setImporteTotal(ordenTrabajoDto.getImporteTotal());
        ordenTrabajo.setKilometraje(ordenTrabajoDto.getKilometraje());
        ordenTrabajo.setNivelCombustible(ordenTrabajoDto.getNivelCombustible());
        ordenTrabajo.setTipoTarjeta(ordenTrabajoDto.getTipoTarjeta());
        ordenTrabajo.setVehiculo(vehiculoMapper.toEntity(ordenTrabajoDto.getVehiculo()));

        return ordenTrabajo;
    }

    @Override
    public OrdenTrabajoDto toDto(OrdenTrabajo ordenTrabajo) {
        if (ordenTrabajo == null) {
            return null;
        }

        OrdenTrabajoDto ordenTrabajoDto = new OrdenTrabajoDto();

        ordenTrabajoDto.setId(ordenTrabajo.getId());
        ordenTrabajoDto.setCantidadCuotas(ordenTrabajo.getCantidadCuotas());
        ordenTrabajoDto.setDetalleFalla(ordenTrabajo.getDetalleFalla());
        ordenTrabajoDto.setEstado(ordenTrabajo.getEstado());
        ordenTrabajoDto.setFechaFinReparacion(ordenTrabajo.getFechaFinReparacion());
        ordenTrabajoDto.setFechaIngreso(ordenTrabajo.getFechaIngreso());
        ordenTrabajoDto.setFechaPago(ordenTrabajo.getFechaPago());
        ordenTrabajoDto.setFormaPago(ordenTrabajo.getFormaPago());
        ordenTrabajoDto.setImporteTotal(ordenTrabajo.getImporteTotal());
        ordenTrabajoDto.setKilometraje(ordenTrabajo.getKilometraje());
        ordenTrabajoDto.setNivelCombustible(ordenTrabajo.getNivelCombustible());
        ordenTrabajoDto.setTipoTarjeta(ordenTrabajo.getTipoTarjeta());
        ordenTrabajoDto.setVehiculo(vehiculoMapper.toDto(ordenTrabajo.getVehiculo()));
        ordenTrabajoDto.setMecanicoId(manoObraService.findByOrdenTrabajo_Id(ordenTrabajo.getId()).getId());

        return ordenTrabajoDto;
    }
}