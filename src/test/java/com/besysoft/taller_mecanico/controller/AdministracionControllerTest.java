package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.FormaPagoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.FormaPagoMapper;
import com.besysoft.taller_mecanico.data.LoadData;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.service.interfaces.AdministracionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.besysoft.taller_mecanico.data.LoadData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdministracionController.class)
class AdministracionControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    AdministracionService service;
    @MockBean
    FormaPagoMapper formaPagoMapper;

    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void facturar() throws Exception {
        FormaPagoDto formaPagoDto = crearFormaPagoDto();
        OrdenTrabajo ordenTrabajo = crearOrdenTrabajo().orElseThrow();
        when(formaPagoMapper.toEntity(any())).thenReturn(ordenTrabajo);

        mvc.perform(put("/administracion/{empleadoId}/facturar", 2L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(formaPagoDto)))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.mensaje").value("Facturacion exitosa"));

        verify(service, times(1)).facturar(anyLong(), any(OrdenTrabajo.class));
        verify(formaPagoMapper, times(1)).toEntity(any(FormaPagoDto.class));
    }
}