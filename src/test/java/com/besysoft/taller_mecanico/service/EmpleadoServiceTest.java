package com.besysoft.taller_mecanico.service;

import com.besysoft.taller_mecanico.domain.entity.Empleado;
import com.besysoft.taller_mecanico.repository.EmpleadoRepository;
import com.besysoft.taller_mecanico.service.interfaces.EmpleadoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.besysoft.taller_mecanico.data.LoadData.crearEmpleadoAdmin;
import static com.besysoft.taller_mecanico.data.LoadData.crearEmpleadoRecep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmpleadoServiceTest {

    @MockBean
    EmpleadoRepository empleadoRepository;

    @Autowired
    EmpleadoService service;

    @Test
    void findAll() {
        List<Empleado> empleados = Arrays.asList(crearEmpleadoRecep().orElseThrow(),
                crearEmpleadoAdmin().orElseThrow());
        when(empleadoRepository.findAll()).thenReturn(empleados);

        List<Empleado> empleadoList = service.findAll();

        verify(empleadoRepository, times(1)).findAll();
        assertFalse(empleadoList.isEmpty());
        assertEquals(2, empleadoList.size());
    }

    @Test
    void alta() {
        Optional<Empleado> empleado = crearEmpleadoRecep();
        when(empleadoRepository.save(empleado.orElseThrow()))
                .thenReturn(empleado.orElseThrow());

        Empleado alta = service.alta(empleado.orElseThrow());

        verify(empleadoRepository, times(1)).save(any());
        assertEquals(alta, empleado.orElseThrow());
    }

    @Test
    void bajaById() {

        service.bajaById(1L);

        verify(empleadoRepository).deleteById(any());
    }
}