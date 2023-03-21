package com.besysoft.taller_mecanico.service;

import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.repository.OrdenTrabajoRepository;
import com.besysoft.taller_mecanico.service.interfaces.OrdenTrabajoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static com.besysoft.taller_mecanico.data.LoadData.crearOrdenTrabajo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrdenTrabajoServiceTest {

    @MockBean
    OrdenTrabajoRepository ordenTrabajoRepository;

    @Autowired
    OrdenTrabajoService service;

    @Test
    void findById() {
        when(ordenTrabajoRepository.findById(1L)).thenReturn(crearOrdenTrabajo());

        Optional<OrdenTrabajo> ordenTrabajo = service.findById(1L);

        verify(ordenTrabajoRepository, times(1)).findById(any());
        assertFalse(ordenTrabajo.isEmpty());
    }

    @Test
    void findAll() {
        when(ordenTrabajoRepository.findAll()).thenReturn(List.of(crearOrdenTrabajo().orElseThrow()));

        List<OrdenTrabajo> ordenTrabajoList = service.findAll();

        assertFalse(ordenTrabajoList.isEmpty());
        assertEquals("Carburador" , ordenTrabajoList.get(0).getDetalleFalla());
        verify(ordenTrabajoRepository).findAll();
    }
}