package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.Mecanico;

import java.util.List;

public interface MecanicoService {

    List<Mecanico> findAll();

    Mecanico alta(Mecanico mecanico);

    void bajaById(Long id);

}
