package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.ManoObra;

public interface ManoObraService {
    ManoObra findByOrdenTrabajo_Id(Long id);
}
