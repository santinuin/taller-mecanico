package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.domain.entity.Cliente;
import com.besysoft.taller_mecanico.repository.ClienteRepository;
import com.besysoft.taller_mecanico.service.interfaces.ClienteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public List<Cliente> findAll() {

        return this.clienteRepository.findAll();
    }
}
