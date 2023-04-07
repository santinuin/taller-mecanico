package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;

public interface AdministracionService {

    void facturar(Long empleadoId, OrdenTrabajo ordenTrabajo) throws InvalidRolException;
}
