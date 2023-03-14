package com.besysoft.taller_mecanico.repository;

import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManoObraRepository extends JpaRepository<ManoObra, Long> {
}