package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;

import java.util.List;
import java.util.Optional;

public interface OrdenTrabajoService {

    List<OrdenTrabajo> findAll();

    Optional<OrdenTrabajo> findById(Long id);
}
