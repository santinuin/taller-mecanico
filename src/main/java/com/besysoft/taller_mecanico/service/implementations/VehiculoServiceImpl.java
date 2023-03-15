package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.business.mapper.VehiculoMapper;
import com.besysoft.taller_mecanico.domain.entity.Vehiculo;
import com.besysoft.taller_mecanico.repository.VehiculoRepository;
import com.besysoft.taller_mecanico.service.interfaces.VehiculoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    private final VehiculoMapper vehiculoMapper;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository, VehiculoMapper vehiculoMapper) {
        this.vehiculoRepository = vehiculoRepository;
        this.vehiculoMapper = vehiculoMapper;
    }

    @Override
    @Transactional
    public List<Vehiculo> findAll() {

        return this.vehiculoRepository.findAll();
    }
}
