package com.besysoft.taller_mecanico.service;

import com.besysoft.taller_mecanico.domain.entity.DetalleOrdenTrabajo;
import com.besysoft.taller_mecanico.repository.DetalleOrdenTrabajoRepository;
import com.besysoft.taller_mecanico.service.interfaces.DetalleOrdenTrabajoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static com.besysoft.taller_mecanico.data.LoadData.crearDetalle;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class DetalleOrdenTrabajoServiceTest {

    @MockBean
    DetalleOrdenTrabajoRepository detalleOrdenTrabajoRepository;

    @Autowired
    DetalleOrdenTrabajoService service;

    @Test
    void findByRepuesto_Id() {
        Optional<DetalleOrdenTrabajo> detalle = crearDetalle();
        when(detalleOrdenTrabajoRepository.findByRepuesto_Id(1L)).thenReturn(detalle);

        service.findByRepuesto_Id(1L);

        verify(detalleOrdenTrabajoRepository, times(1)).findByRepuesto_Id(1L);
        assertEquals(detalle.get().getRepuesto().getId(), 1L);
    }
}