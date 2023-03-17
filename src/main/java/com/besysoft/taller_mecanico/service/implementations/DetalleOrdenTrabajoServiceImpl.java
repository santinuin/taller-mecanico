package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.domain.entity.DetalleOrdenTrabajo;
import com.besysoft.taller_mecanico.repository.DetalleOrdenTrabajoRepository;
import com.besysoft.taller_mecanico.service.interfaces.DetalleOrdenTrabajoService;
import org.springframework.stereotype.Service;

@Service
public class DetalleOrdenTrabajoServiceImpl implements DetalleOrdenTrabajoService {

    private final DetalleOrdenTrabajoRepository detalleOrdenTrabajoRepository;

    public DetalleOrdenTrabajoServiceImpl(DetalleOrdenTrabajoRepository detalleOrdenTrabajoRepository) {
        this.detalleOrdenTrabajoRepository = detalleOrdenTrabajoRepository;
    }

    @Override
    public DetalleOrdenTrabajo findByRepuesto_Id(Long id) {

        return this.detalleOrdenTrabajoRepository.findByRepuesto_Id(id).orElseThrow();
    }
}
