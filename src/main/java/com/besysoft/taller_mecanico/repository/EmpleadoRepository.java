package com.besysoft.taller_mecanico.repository;

import com.besysoft.taller_mecanico.domain.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}