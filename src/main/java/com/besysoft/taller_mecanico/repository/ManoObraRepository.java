package com.besysoft.taller_mecanico.repository;

import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ManoObraRepository extends JpaRepository<ManoObra, Long> {
    Optional<ManoObra> findByOrdenTrabajo_Id(Long id);

    List<ManoObra> findByMecanico_Id(Long id);
}