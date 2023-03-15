package com.besysoft.taller_mecanico.repository;

import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Long> {
}