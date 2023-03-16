package com.besysoft.taller_mecanico.business.mapper.implementations;

import com.besysoft.taller_mecanico.business.dto.RepuestoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.RepuestoMapper;
import com.besysoft.taller_mecanico.domain.entity.Repuesto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Component
public class RepuestoMapperImpl implements RepuestoMapper {

    @Override
    public Repuesto toEntity(RepuestoDto repuestoDto) {
        if ( repuestoDto == null ) {
            return null;
        }

        Repuesto repuesto = new Repuesto();

        repuesto.setId( repuestoDto.getId() );
        repuesto.setMarca( repuestoDto.getMarca() );
        repuesto.setModelo( repuestoDto.getModelo() );
        repuesto.setRespuesto( repuestoDto.getRespuesto() );
        repuesto.setValor( repuestoDto.getValor() );

        return repuesto;
    }

    @Override
    public RepuestoDto toDto(Repuesto repuesto) {
        if ( repuesto == null ) {
            return null;
        }

        RepuestoDto repuestoDto = new RepuestoDto();

        repuestoDto.setId( repuesto.getId() );
        repuestoDto.setMarca( repuesto.getMarca() );
        repuestoDto.setModelo( repuesto.getModelo() );
        repuestoDto.setRespuesto( repuesto.getRespuesto() );
        repuestoDto.setValor( repuesto.getValor() );

        return repuestoDto;
    }

    @Override
    public Repuesto partialUpdate(RepuestoDto repuestoDto, Repuesto repuesto) {
        if ( repuestoDto == null ) {
            return repuesto;
        }

        if ( repuestoDto.getId() != null ) {
            repuesto.setId( repuestoDto.getId() );
        }
        if ( repuestoDto.getMarca() != null ) {
            repuesto.setMarca( repuestoDto.getMarca() );
        }
        if ( repuestoDto.getModelo() != null ) {
            repuesto.setModelo( repuestoDto.getModelo() );
        }
        if ( repuestoDto.getRespuesto() != null ) {
            repuesto.setRespuesto( repuestoDto.getRespuesto() );
        }
        if ( repuestoDto.getValor() != null ) {
            repuesto.setValor( repuestoDto.getValor() );
        }

        return repuesto;
    }
}
