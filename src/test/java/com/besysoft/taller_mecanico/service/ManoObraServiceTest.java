package com.besysoft.taller_mecanico.service;

import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import com.besysoft.taller_mecanico.repository.ManoObraRepository;
import com.besysoft.taller_mecanico.service.interfaces.ManoObraService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static com.besysoft.taller_mecanico.data.LoadData.crearManoObra;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@SpringBootTest
class ManoObraServiceTest {

    @MockBean
    ManoObraRepository manoObraRepository;

    @Autowired
    ManoObraService service;

    @Test
    void findAll() {
        when(manoObraRepository.findAll()).thenReturn(List.of(crearManoObra().orElseThrow()));

        List<ManoObra> manoObraList = service.findAll();

        assertFalse(manoObraList.isEmpty());
        assertEquals(1L, manoObraList.get(0).getId());
        verify(manoObraRepository).findAll();
    }

    @Test
    void findByOrdenTrabajo_Id() {
        Optional<ManoObra> manoObra = crearManoObra();
        when(manoObraRepository.findByOrdenTrabajo_Id(1L)).thenReturn(manoObra);

        service.findByOrdenTrabajo_Id(1L);

        verify(manoObraRepository, times(1)).findByOrdenTrabajo_Id(1L);
        assertEquals(manoObra.get().getOrdenTrabajo().getId(), 1L);
    }
}