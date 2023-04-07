package com.besysoft.taller_mecanico.repository;

import com.besysoft.taller_mecanico.domain.entity.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepuestoRepository extends JpaRepository<Repuesto, Long> {
}