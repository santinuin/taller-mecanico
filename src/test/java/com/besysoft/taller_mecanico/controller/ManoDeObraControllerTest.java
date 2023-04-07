package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.ManoObraDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.ManoObraMapper;
import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import com.besysoft.taller_mecanico.service.interfaces.ManoObraService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.besysoft.taller_mecanico.data.LoadData.crearManoObra;
import static com.besysoft.taller_mecanico.data.LoadData.crearManoObraDto;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ManoDeObraController.class)
class ManoDeObraControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    ManoObraService service;
    @MockBean
    ManoObraMapper manoObraMapper;

    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void findAll() throws Exception {
        List<ManoObra> manoObraList = List.of(crearManoObra().orElseThrow());
        ManoObraDto manoObraDto = crearManoObraDto();
        when(service.findAll()).thenReturn(manoObraList);
        when(manoObraMapper.toDto(any())).thenReturn(manoObraDto);

        mvc.perform(get("/mano-obra").contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(1));
        verify(service).findAll();
        verify(manoObraMapper).toDto(any(ManoObra.class));
    }
}