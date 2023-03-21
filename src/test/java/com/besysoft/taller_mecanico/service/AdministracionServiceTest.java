package com.besysoft.taller_mecanico.service;

import com.besysoft.taller_mecanico.domain.entity.Empleado;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.domain.enumerations.EstadoOrdenEnum;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;
import com.besysoft.taller_mecanico.repository.EmpleadoRepository;
import com.besysoft.taller_mecanico.repository.OrdenTrabajoRepository;
import com.besysoft.taller_mecanico.service.interfaces.AdministracionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static com.besysoft.taller_mecanico.data.LoadData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class AdministracionServiceTest {

    @MockBean
    OrdenTrabajoRepository ordenTrabajoRepository;

    @MockBean
    EmpleadoRepository empleadoRepository;

    @Autowired
    AdministracionService service;

    @Test
    @DisplayName("Facturar")
    void facturar() throws InvalidRolException {
        Optional<OrdenTrabajo> ordenTrabajo = crearOrdenTrabajo();
        Optional<Empleado> empleado = crearEmpleadoAdmin();
        when(empleadoRepository.findById(2L)).thenReturn(empleado);

        service.facturar(2L, ordenTrabajo.orElseThrow());

        assertEquals(EstadoOrdenEnum.FACTURADA, ordenTrabajo.get().getEstado());
        assertThat(ordenTrabajo.get().getFechaPago())
                .isCloseTo(LocalDateTime.now(), within(1, ChronoUnit.HOURS));
        assertEquals(empleado.orElseThrow(), ordenTrabajo.get().getAdministrativo());
        verify(ordenTrabajoRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("Facturar, empleado erroneo")
    void facturarException() {
        Optional<OrdenTrabajo> ordenTrabajo = crearOrdenTrabajo();
        Optional<Empleado> empleadoErroneo = crearEmpleadoRecep();
        when(empleadoRepository.findById(1L)).thenReturn(empleadoErroneo);

        assertThrows(InvalidRolException.class, () -> service.facturar(1L, ordenTrabajo.orElseThrow()));

        verify(ordenTrabajoRepository, never()).save(any());
    }
}