package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.DetalleOrdenTrabajo;

public interface DetalleOrdenTrabajoService {

    DetalleOrdenTrabajo findByRepuesto_Id(Long id);

}
