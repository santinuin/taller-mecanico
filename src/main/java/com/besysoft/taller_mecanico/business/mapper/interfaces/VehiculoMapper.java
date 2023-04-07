package com.besysoft.taller_mecanico.business.mapper.interfaces;

import com.besysoft.taller_mecanico.business.dto.VehiculoDto;
import com.besysoft.taller_mecanico.domain.entity.Vehiculo;

public interface VehiculoMapper {
    Vehiculo toEntity(VehiculoDto vehiculoDto);

    VehiculoDto toDto(Vehiculo vehiculo);
}