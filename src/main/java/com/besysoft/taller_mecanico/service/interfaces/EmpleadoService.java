package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.Empleado;

import java.util.List;

public interface EmpleadoService {

    List<Empleado> findAll();

    Empleado alta(Empleado empleado);

    void bajaById(Long id);

}
