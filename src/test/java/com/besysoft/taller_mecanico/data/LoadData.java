package com.besysoft.taller_mecanico.data;

import com.besysoft.taller_mecanico.domain.entity.*;
import com.besysoft.taller_mecanico.domain.enumerations.TipoEmpleadoEnum;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class LoadData {

    /* Crear vehiculo */
    public static Optional<Vehiculo> crearVehiculo() {
        return Optional.of(new Vehiculo(1L, 2012, "Rojo", "Fiat", "Uno", "AAA111", null));
    }

    /* Crear cliente */
    public static Optional<Cliente> crearCliente() {
        return Optional.of(new Cliente(1L, "Perez", "111111111", "Calle", "1111", "Departamento", "Localidad", "11", "1", "juanperez@prueba.com", "Juan", "1111111", List.of(crearVehiculo().orElseThrow())));
    }

    /* Crear empleado */

    public static Optional<Empleado> crearEmpleadoRecep() {
        return Optional.of(new Empleado(1L, "Nuñez", "155129748", "Calasanz", "5107", "Colon", "Córdoba", "2770", "1", "Santiago", TipoEmpleadoEnum.RECEPCIONISTA));
    }

    public static Optional<Empleado> crearEmpleadoAdmin() {
        return Optional.of(new Empleado(2L, "Mendoza", "156158749", "Peatonal", "5000", "Capital", "Cordoba", "1550", "1", "Carlos", TipoEmpleadoEnum.ADMINISTRATIVO));
    }

    /* Crear mecanico */

    public static Optional<Mecanico> crearMecanico() {
        return Optional.of(new Mecanico(1L, 'A', "Gomez", "156894854", "Publica", "5000", "Capital", "Córdoba", "35", "1", "Generalista", "Alberto"));
    }

    /* Crear repuesto */

    public static Optional<Repuesto> crearRepuesto() {
        return Optional.of(new Repuesto(1L, "Fiat", "Uno", "Carburador", new BigDecimal(55000)));
    }

    /* Crear orden */

    public static Optional<OrdenTrabajo> crearOrdenTrabajo() {
        return Optional.of(new OrdenTrabajo(1L, null, "Carburador", null, null, null, null, null, null, 80000L, "Medio", null, null, crearEmpleadoRecep().orElseThrow(), crearVehiculo().orElseThrow()));
    }

    /* Crear mano obra */
    public static Optional<ManoObra> crearManoObra() {
        return Optional.of(new ManoObra(1L, null, null, crearMecanico().orElseThrow(), crearOrdenTrabajo().orElseThrow()));
    }

}
