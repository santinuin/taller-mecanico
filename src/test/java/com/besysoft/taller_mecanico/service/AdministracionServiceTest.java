package com.besysoft.taller_mecanico.service;

import com.besysoft.taller_mecanico.repository.EmpleadoRepository;
import com.besysoft.taller_mecanico.repository.OrdenTrabajoRepository;
import com.besysoft.taller_mecanico.service.interfaces.AdministracionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

class AdministracionServiceTest {

    @MockBean
    OrdenTrabajoRepository ordenTrabajoRepository;

    @MockBean
    EmpleadoRepository empleadoRepository;

    @Autowired
    AdministracionService service;

    @Test
    void facturar() {
    }
}