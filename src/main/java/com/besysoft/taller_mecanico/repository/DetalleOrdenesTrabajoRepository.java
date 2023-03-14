package com.besysoft.taller_mecanico.repository;

import com.besysoft.taller_mecanico.domain.entity.DetalleOrdenesTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleOrdenesTrabajoRepository extends JpaRepository<DetalleOrdenesTrabajo, Long> {
}