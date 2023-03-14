package com.besysoft.taller_mecanico.repository;

import com.besysoft.taller_mecanico.domain.entity.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
}