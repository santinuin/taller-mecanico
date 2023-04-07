package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.VehiculoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.VehiculoMapper;
import com.besysoft.taller_mecanico.domain.entity.Vehiculo;
import com.besysoft.taller_mecanico.service.interfaces.VehiculoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.besysoft.taller_mecanico.data.LoadData.crearVehiculo;
import static com.besysoft.taller_mecanico.data.LoadData.crearVehiculoDto;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VehiculoController.class)
class VehiculoControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    VehiculoService service;
    @MockBean
    VehiculoMapper vehiculoMapper;

    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void findAll() throws Exception {
        List<Vehiculo> vehiculoList = List.of(crearVehiculo().orElseThrow());
        VehiculoDto vehiculoDto = crearVehiculoDto();
        when(service.findAll()).thenReturn(vehiculoList);
        when(vehiculoMapper.toDto(any())).thenReturn(vehiculoDto);

        mvc.perform(get("/vehiculo").contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].patente").value("AAA111"));
        verify(service).findAll();
        verify(vehiculoMapper).toDto(any(Vehiculo.class));
    }
}