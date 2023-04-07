package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.domain.entity.Mecanico;
import com.besysoft.taller_mecanico.repository.MecanicoRepository;
import com.besysoft.taller_mecanico.service.interfaces.MecanicoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MecanicoServiceImpl implements MecanicoService {

    private final MecanicoRepository mecanicoRepository;

    public MecanicoServiceImpl(MecanicoRepository mecanicoRepository) {
        this.mecanicoRepository = mecanicoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mecanico> findAll() {
        return this.mecanicoRepository.findAll();
    }

    @Override
    @Transactional
    public Mecanico alta(Mecanico mecanico) {
        return this.mecanicoRepository.save(mecanico);
    }

    @Override
    @Transactional
    public void bajaById(Long id) {
        this.mecanicoRepository.deleteById(id);
    }
}
