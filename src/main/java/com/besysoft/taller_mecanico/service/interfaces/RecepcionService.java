package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.Cliente;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;

public interface RecepcionService {

    void recibirClienteYVehiculo(Long empleadoId, Cliente cliente) throws InvalidRolException;

    void generarOrdenDeTrabajo(Long empleadoId, String nivelCombustible, Long kilometraje, String detalleFalla, String patenteVehiculo, Long mecanicoId) throws InvalidRolException;

}
