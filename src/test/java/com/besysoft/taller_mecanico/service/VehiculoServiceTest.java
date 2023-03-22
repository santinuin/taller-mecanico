package com.besysoft.taller_mecanico.service;

import com.besysoft.taller_mecanico.domain.entity.Vehiculo;
import com.besysoft.taller_mecanico.repository.VehiculoRepository;
import com.besysoft.taller_mecanico.service.interfaces.VehiculoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static com.besysoft.taller_mecanico.data.LoadData.crearVehiculo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class VehiculoServiceTest {

    @MockBean
    VehiculoRepository vehiculoRepository;

    @Autowired
    VehiculoService service;

    @Test
    void findAll() {
        when(vehiculoRepository.findAll()).thenReturn(List.of(crearVehiculo().orElseThrow()));

        List<Vehiculo> vehiculoList = service.findAll();

        assertFalse(vehiculoList.isEmpty());
        assertEquals("AAA111", vehiculoList.get(0).getPatente());
        verify(vehiculoRepository).findAll();
    }
}