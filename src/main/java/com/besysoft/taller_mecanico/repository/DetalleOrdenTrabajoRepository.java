package com.besysoft.taller_mecanico.repository;

import com.besysoft.taller_mecanico.domain.entity.DetalleOrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetalleOrdenTrabajoRepository extends JpaRepository<DetalleOrdenTrabajo, Long> {
    Optional<DetalleOrdenTrabajo> findByRepuesto_Id(Long id);

}