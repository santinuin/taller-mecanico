package com.besysoft.taller_mecanico.repository;

import com.besysoft.taller_mecanico.domain.entity.OrdenesTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenesTrabajoRepository extends JpaRepository<OrdenesTrabajo, Long> {
}