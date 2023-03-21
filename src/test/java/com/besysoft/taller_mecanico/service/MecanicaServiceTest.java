package com.besysoft.taller_mecanico.service;

import com.besysoft.taller_mecanico.domain.entity.DetalleOrdenTrabajo;
import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.domain.entity.Repuesto;
import com.besysoft.taller_mecanico.domain.enumerations.EstadoOrdenEnum;
import com.besysoft.taller_mecanico.repository.DetalleOrdenTrabajoRepository;
import com.besysoft.taller_mecanico.repository.ManoObraRepository;
import com.besysoft.taller_mecanico.repository.OrdenTrabajoRepository;
import com.besysoft.taller_mecanico.service.interfaces.MecanicaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import static com.besysoft.taller_mecanico.data.LoadData.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class MecanicaServiceTest {

    @MockBean
    OrdenTrabajoRepository ordenTrabajoRepository;
    @MockBean
    ManoObraRepository manoObraRepository;
    @MockBean
    DetalleOrdenTrabajoRepository detalleOrdenTrabajoRepository;

    @Autowired
    MecanicaService service;


    @Test
    @DisplayName("Listar manos de obra previamente asignadas")
    void listarManosDeObraAsignadas() {
        ManoObra manoObraAsignada = crearManoObra().orElseThrow();
        manoObraAsignada.getOrdenTrabajo().setEstado(EstadoOrdenEnum.CREADA);
        when(manoObraRepository.findByMecanico_Id(1L)).thenReturn(List.of(manoObraAsignada));

        List<ManoObra> manoObraAsignadaList = service.listarManosDeObraAsignadas(1L);

        assertEquals(1, manoObraAsignadaList.size());
        assertEquals(1L, manoObraAsignadaList.get(0).getMecanico().getId());
        assertEquals(EstadoOrdenEnum.CREADA, manoObraAsignadaList.get(0).getOrdenTrabajo().getEstado());

    }
    @Test
    @DisplayName("Listar manos de obra asignadas, cuando ninguna esta en estado creada")
    void listarManosDeObraAsignadasEmpty() {
        when(manoObraRepository.findByMecanico_Id(1L)).thenReturn(List.of(crearManoObra().orElseThrow()));

        List<ManoObra> manoObraSinAsignarList = service.listarManosDeObraAsignadas(1L);

        assertEquals(0, manoObraSinAsignarList.size());
    }

    @Test
    @DisplayName("Inicio de reparacion, cambio de estado de orden")
    void iniciarReparacion() {
        OrdenTrabajo ordenTrabajo = crearOrdenTrabajo().orElseThrow();
        ManoObra manoObra = crearManoObra().orElseThrow();
        manoObra.setOrdenTrabajo(ordenTrabajo);
        when(manoObraRepository.findById(1L)).thenReturn(Optional.of(manoObra));

        service.iniciarReparacion(1L);

        assertEquals(EstadoOrdenEnum.EN_REPARACION, ordenTrabajo.getEstado());
        verify(ordenTrabajoRepository, times(1)).save(any(OrdenTrabajo.class));

    }

    @Test
    @DisplayName("Finalizar reparacion, cambio de estado de orden")
    void finalizarReparacion() {
        Optional<ManoObra> manoObra = crearManoObra();

        when(manoObraRepository.findById(1L)).thenReturn(manoObra);
        when(ordenTrabajoRepository.findById(anyLong())).thenReturn(Optional.of(manoObra.orElseThrow().getOrdenTrabajo()));

        service.finalizarReparacion(1L, "Carburador", 5L);

        assertEquals("Carburador", manoObra.get().getDetalle());
        assertEquals(Duration.ofHours(5L), manoObra.get().getDuracionHs());
        assertThat(manoObra.get().getOrdenTrabajo().getFechaFinReparacion())
                .isCloseTo(LocalDateTime.now(), within(1, ChronoUnit.HOURS));
        verify(manoObraRepository, times(1)).save(any(ManoObra.class));
    }

    @Test
    @DisplayName("Carga de repuesto")
    void cargarRepuestos() {
        Optional<Repuesto> repuesto = crearRepuesto();
        Optional<ManoObra> manoObra = crearManoObra();
        when(manoObraRepository.findById(1L)).thenReturn(manoObra);

        service.cargarRepuestos(1L, repuesto.orElseThrow(), 1);

        verify(detalleOrdenTrabajoRepository, times(1))
                .save(any(DetalleOrdenTrabajo.class));
    }

    @Test
    @DisplayName("Orden para facturar, cambio de estado de orden")
    void ordenParaFacturar() {
        Optional<ManoObra> manoObra = crearManoObra();
        when(manoObraRepository.findById(1L)).thenReturn(manoObra);

        service.ordenParaFacturar(1L);

        assertEquals(EstadoOrdenEnum.PARA_FACTURAR, manoObra.get().getOrdenTrabajo().getEstado());
        verify(ordenTrabajoRepository, times(1)).save(manoObra.get().getOrdenTrabajo());
    }
}