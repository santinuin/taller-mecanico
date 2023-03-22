package com.besysoft.taller_mecanico.data;

import com.besysoft.taller_mecanico.business.dto.*;
import com.besysoft.taller_mecanico.business.mapper.interfaces.FormaPagoMapper;
import com.besysoft.taller_mecanico.domain.entity.*;
import com.besysoft.taller_mecanico.domain.enumerations.TipoEmpleadoEnum;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class LoadData {
    //ENTITIES
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

    public static Optional<DetalleOrdenTrabajo> crearDetalle() {
        return Optional.of(new DetalleOrdenTrabajo(1L, 1, new BigDecimal("55000"), crearOrdenTrabajo().orElseThrow(), crearRepuesto().orElseThrow()));
    }


    //DTOS
    /* Crear vehiculo */
    public static VehiculoDto crearVehiculoDto() {
        return new VehiculoDto(null, 2012, "Rojo", "Fiat", "Uno", "AAA111");
    }

    /* Crear cliente */
    public static ClienteDto crearClienteDto() {
        return new ClienteDto(1L, "Perez", "111111111", "Calle", "1111", "Departamento", "Localidad", "11", "1", "juanperez@prueba.com", "Juan", "1111111", List.of(crearVehiculoDto()));
    }

    /* Crear empleado */

    public static EmpleadoDto crearEmpleadoRecepDto() {
        return new EmpleadoDto(null, "Nuñez", "155129748", "Calasanz", "5107", "Colon", "Córdoba", "2770", "1", "Santiago", TipoEmpleadoEnum.RECEPCIONISTA);
    }

    public static EmpleadoDto crearEmpleadoAdminDto() {
        return new EmpleadoDto(null, "Mendoza", "156158749", "Peatonal", "5000", "Capital", "Cordoba", "1550", "1", "Carlos", TipoEmpleadoEnum.ADMINISTRATIVO);
    }

    /* Crear mecanico */

    public static MecanicoDto crearMecanicoDto() {
        return new MecanicoDto(1L, 'A', "Gomez", "156894854", "Publica", "5000", "Capital", "Córdoba", "35", "1", "Generalista", "Alberto");
    }

    /* Crear repuesto */

    public static RepuestoDto crearRepuestoDto() {
        return new RepuestoDto(null, "Fiat", "Uno", "Carburador", new BigDecimal(55000), 1);
    }

    /* Crear orden */

    public static OrdenTrabajoDto crearOrdenTrabajoDto() {
        return new OrdenTrabajoDto(null, null, "Carburador", null, null, null, null, null, null, 80000L, "Medio", null, crearVehiculoDto(), 1L);
    }

    /* Crear mano obra */
    public static ManoObraDto crearManoObraDto() {
        return new ManoObraDto(1L, null, null, crearMecanicoDto(), crearOrdenTrabajoDto());
    }

    /* Crear forma paago */
    public static FormaPagoDto crearFormaPagoDto() {
        return new FormaPagoDto(1L, 12, null, "Tarjeta", new BigDecimal("80000"), "Debito");
    }
}
