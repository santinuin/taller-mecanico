package com.besysoft.taller_mecanico.service;

import com.besysoft.taller_mecanico.domain.entity.Cliente;
import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.domain.enumerations.EstadoOrdenEnum;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;
import com.besysoft.taller_mecanico.repository.*;
import com.besysoft.taller_mecanico.service.interfaces.RecepcionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static com.besysoft.taller_mecanico.data.LoadData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
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

    @Mock
    Cliente cliente;

    @Autowired
    RecepcionService service;


    @Test
    @DisplayName("Recibir vehiculo existente y cliente existente")
    void recibirClienteYVehiculoExistentes() throws InvalidRolException {

        when(empleadoRepository.findById(anyLong())).thenReturn(crearEmpleadoRecep());
        when(vehiculoRepository.findByPatente(anyString())).thenReturn(crearVehiculo().orElseThrow());
        when(clienteRepository.findByCorreoElectronico(anyString())).thenReturn(crearCliente().orElseThrow());

        service.recibirClienteYVehiculo(1L, crearCliente().orElseThrow());

        verify(empleadoRepository).findById(1L);
        verify(vehiculoRepository).findByPatente(anyString());
        verify(clienteRepository).findByCorreoElectronico(anyString());
        verify(clienteRepository, never()).save(any(Cliente.class));

    }

    @Test
    @DisplayName("Recibir vehiculo existente y cliente inexistente")
    void recibirClienteInexYVehiculoExist() throws InvalidRolException {

        when(empleadoRepository.findById(anyLong())).thenReturn(crearEmpleadoRecep());
        when(vehiculoRepository.findByPatente(anyString())).thenReturn(crearVehiculo().orElseThrow());
        when(clienteRepository.findByCorreoElectronico(anyString())).thenReturn(null);

        service.recibirClienteYVehiculo(1L, crearCliente().orElseThrow());

        verify(empleadoRepository).findById(1L);
        verify(vehiculoRepository).findByPatente(anyString());
        verify(clienteRepository).findByCorreoElectronico(anyString());
        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

    @Test
    @DisplayName("Recibir vehiculo inexistente y cliente existente")
    void recibirClienteExistYVehiculoInex() throws InvalidRolException {

        when(empleadoRepository.findById(anyLong())).thenReturn(crearEmpleadoRecep());
        when(vehiculoRepository.findByPatente(anyString())).thenReturn(null);
        when(clienteRepository.findByCorreoElectronico(anyString())).thenReturn(crearCliente().orElseThrow());

        service.recibirClienteYVehiculo(1L, crearCliente().orElseThrow());

        verify(empleadoRepository).findById(1L);
        verify(vehiculoRepository).findByPatente(anyString());
        verify(clienteRepository).findByCorreoElectronico(anyString());
        verify(clienteRepository, never()).save(any(Cliente.class));
    }

    @Test
    @DisplayName("Recibir vehiculo inexistente y cliente inexistente")
    void recibirClienteYVehiculoInexistentes() throws InvalidRolException {

        when(empleadoRepository.findById(anyLong())).thenReturn(crearEmpleadoRecep());
        when(vehiculoRepository.findByPatente(anyString())).thenReturn(null);
        when(clienteRepository.findByCorreoElectronico(anyString())).thenReturn(null);

        service.recibirClienteYVehiculo(1L, crearCliente().orElseThrow());

        verify(empleadoRepository).findById(1L);
        verify(vehiculoRepository).findByPatente(anyString());
        verify(clienteRepository).findByCorreoElectronico(anyString());
        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

    @Test
    @DisplayName("Recibir vehiculo y cliente, empleado erroneo")
    void recibirClienteYVehiculoThrowsExeption() throws InvalidRolException {

        when(empleadoRepository.findById(anyLong())).thenReturn(crearEmpleadoAdmin());
        when(vehiculoRepository.findByPatente(anyString())).thenReturn(crearVehiculo().orElseThrow());
        when(clienteRepository.findByCorreoElectronico(anyString())).thenReturn(crearCliente().orElseThrow());

        assertThrows(InvalidRolException.class, () -> service.recibirClienteYVehiculo(2L, crearCliente().orElseThrow()));

        verify(empleadoRepository).findById(2L);
        verify(vehiculoRepository, never()).findByPatente(anyString());
        verify(clienteRepository, never()).findByCorreoElectronico(anyString());
        verify(clienteRepository, never()).save(any(Cliente.class));
    }

    @Test
    @DisplayName("Generar orden de Trabajo")
    void generarOrdenDeTrabajo() throws InvalidRolException {
        when(empleadoRepository.findById(1L)).thenReturn(crearEmpleadoRecep());
        when(vehiculoRepository.findByPatente(anyString())).thenReturn(crearVehiculo().orElseThrow());
        OrdenTrabajo ordenTrabajo = mock(OrdenTrabajo.class);

        service.generarOrdenDeTrabajo(1L, "Medio", 80000L, "Tapa", "AAA111", 1L);


        verify(ordenTrabajoRepository).save(any(OrdenTrabajo.class));
        verify(manoObraRepository).save(any(ManoObra.class));
    }

    @Test
    @DisplayName("Generar orden de Trabajo, empleado erroneo")
    void generarOrdenDeTrabajoException() throws InvalidRolException {
        when(empleadoRepository.findById(2L)).thenReturn(crearEmpleadoAdmin());
        when(vehiculoRepository.findByPatente(anyString())).thenReturn(crearVehiculo().orElseThrow());

        assertThrows(InvalidRolException.class, () ->
                service.generarOrdenDeTrabajo(2L, "Medio", 80000L, "Tapa", "AAA111", 1L));

        verify(ordenTrabajoRepository, never()).save(any(OrdenTrabajo.class));
        verify(manoObraRepository, never()).save(any(ManoObra.class));
    }

    @Test
    @DisplayName("Entregar vehiculo y cerrar orden")
    void entregarVehiculo() throws InvalidRolException {
        OrdenTrabajo ordenTrabajo = new OrdenTrabajo();
        when(empleadoRepository.findById(1L)).thenReturn(crearEmpleadoRecep());
        when(ordenTrabajoRepository.findById(1L)).thenReturn(Optional.of(ordenTrabajo));

        service.entregarVehiculo(1L, 1L);

        verify(ordenTrabajoRepository, times(1)).save(any(OrdenTrabajo.class));
        assertEquals(EstadoOrdenEnum.CERRADA, ordenTrabajo.getEstado());
    }

    @Test
    @DisplayName("Entregar vehiculo y cerrar orden, empleado erroneo")
    void entregarVehiculoException() throws InvalidRolException {
        OrdenTrabajo ordenTrabajo = new OrdenTrabajo();
        when(empleadoRepository.findById(2L)).thenReturn(crearEmpleadoAdmin());
        when(ordenTrabajoRepository.findById(1L)).thenReturn(Optional.of(ordenTrabajo));

        assertThrows(InvalidRolException.class, () ->
                service.entregarVehiculo(2L, 1L));

        verify(ordenTrabajoRepository, never()).save(any(OrdenTrabajo.class));
    }
}