package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.domain.entity.Empleado;
import com.besysoft.taller_mecanico.repository.EmpleadoRepository;
import com.besysoft.taller_mecanico.service.interfaces.EmpleadoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> findAll() {
        return this.empleadoRepository.findAll();
    }

    @Override
    @Transactional
    public Empleado alta(Empleado empleado) {
        return this.empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public void bajaById(Long id) {
        this.empleadoRepository.deleteById(id);
    }
}
