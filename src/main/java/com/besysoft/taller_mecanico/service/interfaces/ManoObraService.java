package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.ManoObra;

import java.util.Collection;
import java.util.List;

public interface ManoObraService {
    List<ManoObra> findAll();
    ManoObra findByOrdenTrabajo_Id(Long id);
}
