package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.EmpleadoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.EmpleadoMapper;
import com.besysoft.taller_mecanico.domain.entity.Empleado;
import com.besysoft.taller_mecanico.service.interfaces.EmpleadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static com.besysoft.taller_mecanico.data.LoadData.*;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmpleadoController.class)
class EmpleadoControllerTest {

    @Autowired
    MockMvc mvc;


    @MockBean
    EmpleadoService service;
    @MockBean
    EmpleadoMapper empleadoMapper;

    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }


    @Test
    void findAll() throws Exception {
        List<Empleado> empleadoList = Arrays.asList(crearEmpleadoRecep().orElseThrow(),
                crearEmpleadoAdmin().orElseThrow());
        when(service.findAll()).thenReturn(empleadoList);

        mvc.perform(get("/empleados").contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));

        verify(service).findAll();
        verify(empleadoMapper, times(2)).toDto(any(Empleado.class));
    }

    @Test
    void altaEmpleado() throws Exception {

        EmpleadoDto empleadoDto = crearEmpleadoAdminDto();
        Empleado empleado = crearEmpleadoAdmin().orElseThrow();
        when(empleadoMapper.toEntity(any())).thenReturn(empleado);
        when(service.alta(any())).thenReturn(empleado);

        mvc.perform(post("/empleados/alta").contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(empleadoDto)))

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.mensaje").value("El empleado ha sido creado con éxito"))
                .andExpect(jsonPath("$.empleado.id").value(2))
                .andExpect(jsonPath("$.empleado.nombres").value("Carlos"))
                .andExpect(jsonPath("$.empleado.apellido").value("Mendoza"))
                .andExpect(jsonPath("$.empleado.celular").value("156158749"));
        verify(service).alta(any());
        verify(empleadoMapper).toEntity(any());
    }

    @Test
    void bajaEmpleado() throws Exception {
        mvc.perform(delete("/empleados/baja/{id}", 1L).contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.mensaje").value("El empleado ha sido eliminado"));

        verify(service).bajaById(anyLong());
    }
}