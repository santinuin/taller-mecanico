package com.besysoft.taller_mecanico.repository;

import com.besysoft.taller_mecanico.domain.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}