package com.besysoft.taller_mecanico.service;

import com.besysoft.taller_mecanico.domain.entity.Cliente;
import com.besysoft.taller_mecanico.repository.ClienteRepository;
import com.besysoft.taller_mecanico.service.interfaces.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static com.besysoft.taller_mecanico.data.LoadData.crearCliente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClienteServiceTest {

    @MockBean
    ClienteRepository clienteRepository;

    @Autowired
    ClienteService service;
    @Test
    void findAll() {
        when(clienteRepository.findAll()).thenReturn(List.of(crearCliente().orElseThrow()));

        List<Cliente> clienteList = service.findAll();

        assertFalse(clienteList.isEmpty());
        assertEquals("Juan" , clienteList.get(0).getNombres());
        verify(clienteRepository).findAll();
    }
}