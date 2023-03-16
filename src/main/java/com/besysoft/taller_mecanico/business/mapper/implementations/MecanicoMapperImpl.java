package com.besysoft.taller_mecanico.business.mapper.implementations;

import com.besysoft.taller_mecanico.business.dto.MecanicoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.MecanicoMapper;
import com.besysoft.taller_mecanico.domain.entity.Mecanico;
import org.springframework.stereotype.Component;

@Component
public class MecanicoMapperImpl implements MecanicoMapper {

    @Override
    public Mecanico toEntity(MecanicoDto mecanicoDto) {
        if ( mecanicoDto == null ) {
            return null;
        }

        Mecanico mecanico = new Mecanico();

        mecanico.setId( mecanicoDto.getId() );
        mecanico.setActivo( mecanicoDto.getActivo() );
        mecanico.setApellido( mecanicoDto.getApellido() );
        mecanico.setCelular( mecanicoDto.getCelular() );
        mecanico.setCalle( mecanicoDto.getCalle() );
        mecanico.setCodigoPostal( mecanicoDto.getCodigoPostal() );
        mecanico.setDepartamento( mecanicoDto.getDepartamento() );
        mecanico.setLocalidad( mecanicoDto.getLocalidad() );
        mecanico.setNumero( mecanicoDto.getNumero() );
        mecanico.setPiso( mecanicoDto.getPiso() );
        mecanico.setEspecialidad( mecanicoDto.getEspecialidad() );
        mecanico.setNombres( mecanicoDto.getNombres() );

        return mecanico;
    }

    @Override
    public MecanicoDto toDto(Mecanico mecanico) {
        if ( mecanico == null ) {
            return null;
        }

        MecanicoDto mecanicoDto = new MecanicoDto();

        mecanicoDto.setId( mecanico.getId() );
        mecanicoDto.setActivo( mecanico.getActivo() );
        mecanicoDto.setApellido( mecanico.getApellido() );
        mecanicoDto.setCelular( mecanico.getCelular() );
        mecanicoDto.setCalle( mecanico.getCalle() );
        mecanicoDto.setCodigoPostal( mecanico.getCodigoPostal() );
        mecanicoDto.setDepartamento( mecanico.getDepartamento() );
        mecanicoDto.setLocalidad( mecanico.getLocalidad() );
        mecanicoDto.setNumero( mecanico.getNumero() );
        mecanicoDto.setPiso( mecanico.getPiso() );
        mecanicoDto.setEspecialidad( mecanico.getEspecialidad() );
        mecanicoDto.setNombres( mecanico.getNombres() );

        return mecanicoDto;
    }

    @Override
    public Mecanico partialUpdate(MecanicoDto mecanicoDto, Mecanico mecanico) {
        if ( mecanicoDto == null ) {
            return mecanico;
        }

        if ( mecanicoDto.getId() != null ) {
            mecanico.setId( mecanicoDto.getId() );
        }
        if ( mecanicoDto.getActivo() != null ) {
            mecanico.setActivo( mecanicoDto.getActivo() );
        }
        if ( mecanicoDto.getApellido() != null ) {
            mecanico.setApellido( mecanicoDto.getApellido() );
        }
        if ( mecanicoDto.getCelular() != null ) {
            mecanico.setCelular( mecanicoDto.getCelular() );
        }
        if ( mecanicoDto.getCalle() != null ) {
            mecanico.setCalle( mecanicoDto.getCalle() );
        }
        if ( mecanicoDto.getCodigoPostal() != null ) {
            mecanico.setCodigoPostal( mecanicoDto.getCodigoPostal() );
        }
        if ( mecanicoDto.getDepartamento() != null ) {
            mecanico.setDepartamento( mecanicoDto.getDepartamento() );
        }
        if ( mecanicoDto.getLocalidad() != null ) {
            mecanico.setLocalidad( mecanicoDto.getLocalidad() );
        }
        if ( mecanicoDto.getNumero() != null ) {
            mecanico.setNumero( mecanicoDto.getNumero() );
        }
        if ( mecanicoDto.getPiso() != null ) {
            mecanico.setPiso( mecanicoDto.getPiso() );
        }
        if ( mecanicoDto.getEspecialidad() != null ) {
            mecanico.setEspecialidad( mecanicoDto.getEspecialidad() );
        }
        if ( mecanicoDto.getNombres() != null ) {
            mecanico.setNombres( mecanicoDto.getNombres() );
        }

        return mecanico;
    }
}
