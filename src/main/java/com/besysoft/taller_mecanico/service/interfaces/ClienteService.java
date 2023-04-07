package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

}
