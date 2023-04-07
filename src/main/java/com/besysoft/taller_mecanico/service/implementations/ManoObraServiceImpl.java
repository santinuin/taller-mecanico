package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import com.besysoft.taller_mecanico.repository.ManoObraRepository;
import com.besysoft.taller_mecanico.service.interfaces.ManoObraService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManoObraServiceImpl implements ManoObraService {

    private final ManoObraRepository manoObraRepository;

    public ManoObraServiceImpl(ManoObraRepository manoObraRepository) {
        this.manoObraRepository = manoObraRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ManoObra> findAll() {
        return manoObraRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ManoObra findByOrdenTrabajo_Id(Long id) {
        return this.manoObraRepository.findByOrdenTrabajo_Id(id).orElseThrow();
    }
}
