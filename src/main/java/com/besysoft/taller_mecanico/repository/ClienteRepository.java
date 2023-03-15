package com.besysoft.taller_mecanico.repository;

import com.besysoft.taller_mecanico.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCorreoElectronico(String correoElectronico);

}