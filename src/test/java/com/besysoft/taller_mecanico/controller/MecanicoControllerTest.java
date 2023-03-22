package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.MecanicoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.MecanicoMapper;
import com.besysoft.taller_mecanico.domain.entity.Mecanico;
import com.besysoft.taller_mecanico.service.interfaces.MecanicoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.besysoft.taller_mecanico.data.LoadData.crearMecanico;
import static com.besysoft.taller_mecanico.data.LoadData.crearMecanicoDto;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MecanicoController.class)
class MecanicoControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    MecanicoService service;
    @MockBean
    MecanicoMapper mecanicoMapper;

    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void findAll() throws Exception {
        List<Mecanico> mecanicoList = List.of(crearMecanico().orElseThrow());
        MecanicoDto mecanicoDto = crearMecanicoDto();
        when(service.findAll()).thenReturn(mecanicoList);
        when(mecanicoMapper.toDto(any())).thenReturn(mecanicoDto);

        mvc.perform(get("/mecanicos").contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(content().json(mapper.writeValueAsString(mecanicoList)));
        verify(service).findAll();
        verify(mecanicoMapper).toDto(any(Mecanico.class));
    }

    @Test
    void altaMecanico() throws Exception {
        MecanicoDto mecanicoDto = crearMecanicoDto();
        Mecanico mecanico = crearMecanico().orElseThrow();
        when(mecanicoMapper.toEntity(any())).thenReturn(mecanico);
        when(service.alta(any())).thenReturn(mecanico);

        mvc.perform(post("/mecanicos/alta").contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(mecanicoDto)))

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.mensaje").value("El mecánico ha sido creado con éxito"))
                .andExpect(jsonPath("$.mecanico.id").value(1))
                .andExpect(jsonPath("$.mecanico.activo").value("A"))
                .andExpect(jsonPath("$.mecanico.apellido").value("Gomez"))
                .andExpect(jsonPath("$.mecanico.celular").value("156894854"));
        verify(service).alta(any());
        verify(mecanicoMapper).toEntity(any());
    }

    @Test
    void bajaMecanico() throws Exception {
        mvc.perform(delete("/mecanicos/baja/{id}", 1L).contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.mensaje").value("El mecánico ha sido eliminado"));

        verify(service).bajaById(anyLong());
    }
}