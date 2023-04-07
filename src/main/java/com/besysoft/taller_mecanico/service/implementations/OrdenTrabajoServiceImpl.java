package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.repository.OrdenTrabajoRepository;
import com.besysoft.taller_mecanico.service.interfaces.OrdenTrabajoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenTrabajoServiceImpl implements OrdenTrabajoService {


    private final OrdenTrabajoRepository ordenTrabajoRepository;

    public OrdenTrabajoServiceImpl(OrdenTrabajoRepository ordenTrabajoRepository) {
        this.ordenTrabajoRepository = ordenTrabajoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrdenTrabajo> findAll() {
        return this.ordenTrabajoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrdenTrabajo> findById(Long id) {
        return this.ordenTrabajoRepository.findById(id);
    }
}
