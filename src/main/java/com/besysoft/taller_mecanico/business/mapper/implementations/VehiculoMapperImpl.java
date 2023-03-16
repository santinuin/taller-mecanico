package com.besysoft.taller_mecanico.business.mapper.implementations;

import com.besysoft.taller_mecanico.business.dto.VehiculoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.VehiculoMapper;
import com.besysoft.taller_mecanico.domain.entity.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class VehiculoMapperImpl implements VehiculoMapper {

    @Override
    public Vehiculo toEntity(VehiculoDto vehiculoDto) {
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

    @Override
    public VehiculoDto toDto(Vehiculo vehiculo) {
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
}