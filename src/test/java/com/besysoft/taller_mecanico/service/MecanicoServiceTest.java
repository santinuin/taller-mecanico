package com.besysoft.taller_mecanico.service;

import com.besysoft.taller_mecanico.domain.entity.Empleado;
import com.besysoft.taller_mecanico.domain.entity.Mecanico;
import com.besysoft.taller_mecanico.repository.MecanicoRepository;
import com.besysoft.taller_mecanico.service.interfaces.MecanicoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.besysoft.taller_mecanico.data.LoadData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
class MecanicoServiceTest {

    @MockBean
    MecanicoRepository mecanicoRepository;

    @Autowired
    MecanicoService service;
    @Test
    void findAll() {
        List<Mecanico> mecanicos = List.of(crearMecanico().orElseThrow());
        when(mecanicoRepository.findAll()).thenReturn(mecanicos);

        List<Mecanico> mecanicoList = service.findAll();

        verify(mecanicoRepository, times(1)).findAll();
        assertFalse(mecanicoList.isEmpty());
        assertEquals(1, mecanicoList.size());
    }

    @Test
    void alta() {
        Optional<Mecanico> mecanico = crearMecanico();
        when(mecanicoRepository.save(mecanico.orElseThrow()))
                .thenReturn(mecanico.orElseThrow());

        Mecanico alta = service.alta(mecanico.orElseThrow());

        verify(mecanicoRepository, times(1)).save(any());
        assertEquals(alta, mecanico.orElseThrow());
    }

    @Test
    void bajaById() {

        service.bajaById(1L);

        verify(mecanicoRepository).deleteById(any());
    }
}