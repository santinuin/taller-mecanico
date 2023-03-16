package com.besysoft.taller_mecanico.business.mapper.implementations;

import com.besysoft.taller_mecanico.business.dto.ManoObraDto;
import com.besysoft.taller_mecanico.business.dto.OrdenTrabajoDto;
import com.besysoft.taller_mecanico.business.dto.VehiculoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.ManoObraMapper;
import com.besysoft.taller_mecanico.business.mapper.interfaces.MecanicoMapper;
import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.domain.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManoObraMapperImpl implements ManoObraMapper {

    @Autowired
    private MecanicoMapper mecanicoMapper;

    @Override
    public ManoObra toEntity(ManoObraDto manoObraDto) {
        if ( manoObraDto == null ) {
            return null;
        }

        ManoObra manoObra = new ManoObra();

        manoObra.setId( manoObraDto.getId() );
        manoObra.setDetalle( manoObraDto.getDetalle() );
        manoObra.setDuracionHs( manoObraDto.getDuracionHs() );
        manoObra.setMecanico( mecanicoMapper.toEntity( manoObraDto.getMecanico() ) );
        manoObra.setOrdenTrabajo( ordenTrabajoDtoToOrdenTrabajo( manoObraDto.getOrdenTrabajo() ) );

        return manoObra;
    }

    @Override
    public ManoObraDto toDto(ManoObra manoObra) {
        if ( manoObra == null ) {
            return null;
        }

        ManoObraDto manoObraDto = new ManoObraDto();

        manoObraDto.setId( manoObra.getId() );
        manoObraDto.setDetalle( manoObra.getDetalle() );
        manoObraDto.setDuracionHs( manoObra.getDuracionHs() );
        manoObraDto.setMecanico( mecanicoMapper.toDto( manoObra.getMecanico() ) );
        manoObraDto.setOrdenTrabajo( ordenTrabajoToOrdenTrabajoDto( manoObra.getOrdenTrabajo() ) );

        return manoObraDto;
    }

    protected Vehiculo vehiculoDtoToVehiculo(VehiculoDto vehiculoDto) {
        if ( vehiculoDto == null ) {
            return null;
        }

        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setId( vehiculoDto.getId() );
        vehiculo.setAnio( vehiculoDto.getAnio() );
        vehiculo.setColor( vehiculoDto.getColor() );
        vehiculo.setMarca( vehiculoDto.getMarca() );
        vehiculo.setModelo( vehiculoDto.getModelo() );
        vehiculo.setPatente( vehiculoDto.getPatente() );

        return vehiculo;
    }

    protected OrdenTrabajo ordenTrabajoDtoToOrdenTrabajo(OrdenTrabajoDto ordenTrabajoDto) {
        if ( ordenTrabajoDto == null ) {
            return null;
        }

        OrdenTrabajo ordenTrabajo = new OrdenTrabajo();

        ordenTrabajo.setId( ordenTrabajoDto.getId() );
        ordenTrabajo.setCantidadCuotas( ordenTrabajoDto.getCantidadCuotas() );
        ordenTrabajo.setDetalleFalla( ordenTrabajoDto.getDetalleFalla() );
        ordenTrabajo.setEstado( ordenTrabajoDto.getEstado() );
        ordenTrabajo.setFechaFinReparacion( ordenTrabajoDto.getFechaFinReparacion() );
        ordenTrabajo.setFechaIngreso( ordenTrabajoDto.getFechaIngreso() );
        ordenTrabajo.setFechaPago( ordenTrabajoDto.getFechaPago() );
        ordenTrabajo.setFormaPago( ordenTrabajoDto.getFormaPago() );
        ordenTrabajo.setImporteTotal( ordenTrabajoDto.getImporteTotal() );
        ordenTrabajo.setKilometraje( ordenTrabajoDto.getKilometraje() );
        ordenTrabajo.setNivelCombustible( ordenTrabajoDto.getNivelCombustible() );
        ordenTrabajo.setTipoTarjeta( ordenTrabajoDto.getTipoTarjeta() );
        ordenTrabajo.setVehiculo( vehiculoDtoToVehiculo( ordenTrabajoDto.getVehiculo() ) );

        return ordenTrabajo;
    }

    protected VehiculoDto vehiculoToVehiculoDto(Vehiculo vehiculo) {
        if ( vehiculo == null ) {
            return null;
        }

        VehiculoDto vehiculoDto = new VehiculoDto();

        vehiculoDto.setId( vehiculo.getId() );
        vehiculoDto.setAnio( vehiculo.getAnio() );
        vehiculoDto.setColor( vehiculo.getColor() );
        vehiculoDto.setMarca( vehiculo.getMarca() );
        vehiculoDto.setModelo( vehiculo.getModelo() );
        vehiculoDto.setPatente( vehiculo.getPatente() );

        return vehiculoDto;
    }

    protected OrdenTrabajoDto ordenTrabajoToOrdenTrabajoDto(OrdenTrabajo ordenTrabajo) {
        if ( ordenTrabajo == null ) {
            return null;
        }

        OrdenTrabajoDto ordenTrabajoDto = new OrdenTrabajoDto();

        ordenTrabajoDto.setId( ordenTrabajo.getId() );
        ordenTrabajoDto.setCantidadCuotas( ordenTrabajo.getCantidadCuotas() );
        ordenTrabajoDto.setDetalleFalla( ordenTrabajo.getDetalleFalla() );
        ordenTrabajoDto.setEstado( ordenTrabajo.getEstado() );
        ordenTrabajoDto.setFechaFinReparacion( ordenTrabajo.getFechaFinReparacion() );
        ordenTrabajoDto.setFechaIngreso( ordenTrabajo.getFechaIngreso() );
        ordenTrabajoDto.setFechaPago( ordenTrabajo.getFechaPago() );
        ordenTrabajoDto.setFormaPago( ordenTrabajo.getFormaPago() );
        ordenTrabajoDto.setImporteTotal( ordenTrabajo.getImporteTotal() );
        ordenTrabajoDto.setKilometraje( ordenTrabajo.getKilometraje() );
        ordenTrabajoDto.setNivelCombustible( ordenTrabajo.getNivelCombustible() );
        ordenTrabajoDto.setTipoTarjeta( ordenTrabajo.getTipoTarjeta() );
        ordenTrabajoDto.setVehiculo( vehiculoToVehiculoDto( ordenTrabajo.getVehiculo() ) );

        return ordenTrabajoDto;
    }
}