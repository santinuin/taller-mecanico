package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.Cliente;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;

public interface EmpleadoService {

    void recibirClienteYVehiculo(Long empleadoId, Cliente cliente) throws InvalidRolException;

}
