package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.Vehiculo;

import java.util.List;

public interface VehiculoService {

    List<Vehiculo> findAll();
}
