package com.besysoft.taller_mecanico.service;

import com.besysoft.taller_mecanico.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class RecepcionServiceTest {

    @MockBean
    EmpleadoRepository empleadoRepository;
    @MockBean
    ClienteRepository clienteRepository;
    @MockBean
    VehiculoRepository vehiculoRepository;
    @MockBean
    OrdenTrabajoRepository ordenTrabajoRepository;
    @MockBean
    MecanicoRepository mecanicoRepository;
    @MockBean
    ManoObraRepository manoObraRepository;

    @Test
    void recibirClienteYVehiculo() {
    }

    @Test
    void generarOrdenDeTrabajo() {
    }
}