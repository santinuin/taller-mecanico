package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.ManoObraDto;
import com.besysoft.taller_mecanico.business.dto.OrdenTrabajoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.OrdenTrabajoMapper;
import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.service.interfaces.OrdenTrabajoService;
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
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@WebMvcTest(OrdenTrabajoController.class)
class OrdenTrabajoControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    OrdenTrabajoService service;
    @MockBean
    OrdenTrabajoMapper ordenTrabajoMapper;

    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void findAll() throws Exception {
        List<OrdenTrabajo> ordenTrabajoList = List.of(crearOrdenTrabajo().orElseThrow());
        OrdenTrabajoDto ordenTrabajoDto = crearOrdenTrabajoDto();
        when(service.findAll()).thenReturn(ordenTrabajoList);
        when(ordenTrabajoMapper.toDto(any())).thenReturn(ordenTrabajoDto);

        mvc.perform(get("/orden").contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].detalleFalla").value("Carburador"));
        verify(service).findAll();
        verify(ordenTrabajoMapper).toDto(any(OrdenTrabajo.class));
    }
}