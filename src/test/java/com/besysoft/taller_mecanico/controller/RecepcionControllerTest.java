package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.ClienteDto;
import com.besysoft.taller_mecanico.business.dto.OrdenTrabajoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.ClienteMapper;
import com.besysoft.taller_mecanico.business.mapper.interfaces.OrdenTrabajoMapper;
import com.besysoft.taller_mecanico.service.interfaces.RecepcionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.besysoft.taller_mecanico.data.LoadData.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecepcionController.class)
class RecepcionControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private RecepcionService service;
    @MockBean
    ClienteMapper clienteMapper;
    @MockBean
    OrdenTrabajoMapper ordenTrabajoMapper;


    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void recibir() throws Exception {

        mvc.perform(post("/recepcion/{empleadoId}/recibir", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(crearClienteDto())))

                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.succes").value(true))
                .andExpect(jsonPath("$.mensaje").value("Se ha recibido cliente y vehículo con éxito"));

        verify(service, times(1)).recibirClienteYVehiculo(any(), any());
        verify(clienteMapper, times(1)).toEntity(any(ClienteDto.class));

    }

    @Test
    void generarOrden() throws Exception {
        when(ordenTrabajoMapper.toEntity(any())).thenReturn(crearOrdenTrabajo().orElseThrow());

        mvc.perform(post("/recepcion/{empleadoId}/generar-orden", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(crearOrdenTrabajoDto())))

                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.succes").value(true))
                .andExpect(jsonPath("$.mensaje").value("Se ha generado orden de trabajo con éxito"));

        verify(service, times(1)).generarOrdenDeTrabajo(any(),any(),any(),any(),any(),any());
        verify(ordenTrabajoMapper, times(1)).toEntity(any(OrdenTrabajoDto.class));
    }

    @Test
    void entregarVehiculo() throws Exception {
        when(ordenTrabajoMapper.toEntity(any())).thenReturn(crearOrdenTrabajo().orElseThrow());

        mvc.perform(put("/recepcion/{empleadoId}/entregar/{ordenTrabajoId}", 1L, 1L))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.succes").value(true))
                .andExpect(jsonPath("$.mensaje").value("Entrega de vehiculo exitosa"));

        verify(service, times(1)).entregarVehiculo(any(),any());
    }
}