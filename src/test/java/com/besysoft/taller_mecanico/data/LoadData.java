package com.besysoft.taller_mecanico.data;

import com.besysoft.taller_mecanico.domain.entity.Cliente;
import com.besysoft.taller_mecanico.domain.entity.Empleado;
import com.besysoft.taller_mecanico.domain.entity.Mecanico;
import com.besysoft.taller_mecanico.domain.entity.Vehiculo;
import com.besysoft.taller_mecanico.domain.enumerations.TipoEmpleadoEnum;

import java.util.Optional;

public class LoadData {

    /* Crear vehiculo */
    public static Optional<Vehiculo> crearVehiculo() {
        return Optional.of(new Vehiculo(1L, 2012, "Rojo", "Fiat", "Uno", "AAA111", null));
    }

    /* Crear cliente */
    public static Optional<Cliente> crearCliente() {
        return Optional.of(new Cliente(1L, "Perez", "111111111", "Calle", "1111", "Departamento", "Localidad", "11", "1", "juanperez@prueba.com", "Juan", "1111111", null));
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

}
