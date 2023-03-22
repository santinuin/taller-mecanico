package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.ManoObraDto;
import com.besysoft.taller_mecanico.business.dto.RepuestoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.ManoObraMapper;
import com.besysoft.taller_mecanico.business.mapper.interfaces.RepuestoMapper;
import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import com.besysoft.taller_mecanico.domain.enumerations.EstadoOrdenEnum;
import com.besysoft.taller_mecanico.service.interfaces.MecanicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.besysoft.taller_mecanico.data.LoadData.*;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MecanicaController.class)
class MecanicaControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    MecanicaService service;
    @MockBean
    ManoObraMapper manoObraMapper;
    @MockBean
    RepuestoMapper repuestoMapper;

    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void listarManosDeObraAsignadas() throws Exception {
        ManoObra manoObra = crearManoObra().orElseThrow();
        ManoObraDto manoObraDto = crearManoObraDto();
        manoObraDto.getOrdenTrabajo().setEstado(EstadoOrdenEnum.CREADA);
        when(service.listarManosDeObraAsignadas(1L)).thenReturn(List.of(manoObra));
        when(manoObraMapper.toDto(any())).thenReturn(manoObraDto);

        mvc.perform(get("/mecanica/{mecanicoId}/asignaciones", 1L)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0]", aMapWithSize(5)))
                .andExpect(jsonPath("$[0].mecanico", aMapWithSize(12)))
                .andExpect(jsonPath("$[0].ordenTrabajo.estado").value("CREADA"));

        verify(service).listarManosDeObraAsignadas(anyLong());
        verify(manoObraMapper).toDto(any());

    }

    @Test
    void iniciarReparacion() throws Exception {
        mvc.perform(post("/mecanica/{manoObraId}/iniciar", 1L)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.mensaje").value("Mano de obra iniciada"));

        verify(service, times(1)).iniciarReparacion(any());
    }

    @Test
    void finalizarReparacion() throws Exception {
        ManoObraDto manoObraDto = crearManoObraDto();

        mvc.perform(put("/mecanica/{manoObraId}/finalizar", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(manoObraDto)))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.mensaje").value("Mano de obra completada con éxito"));

        verify(service).finalizarReparacion(any(), any(), any());
    }

    @Test
    void cargarRepuestos() throws Exception {
        RepuestoDto repuestoDto = crearRepuestoDto();

        mvc.perform(post("/mecanica/{manoObraId}/cargar-repuesto", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(repuestoDto)))

                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.mensaje").value("Repuesto cargado con éxito"));
        verify(repuestoMapper).toEntity(any(RepuestoDto.class));
        verify(service).cargarRepuestos(any(), any(), any());
    }

    @Test
    void ordenParaFacturar() throws Exception {


        mvc.perform(put("/mecanica/{manoObraId}/para-facturar", 1L)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.mensaje").value("Orden lista para facturar"));

        verify(service).ordenParaFacturar(any());

    }
}