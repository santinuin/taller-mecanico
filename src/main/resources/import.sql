/* Populate table clientes */

INSERT INTO `taller_mecanico`.`clientes` (`id`, `apellido`, `calle`, `celular`, `codigo_postal`, `correo_electronico`, `departamento`, `localidad`, `nombres`, `numero`, `piso`, `telefono_linea`) VALUES ('1', 'Perez', 'Calle', '111111111', '1111', 'juanperez@prueba.com', 'Prueba', 'Prueba', 'Juan', '1', '1', '1111111');

/* Populate table vehiculos */

INSERT INTO `taller_mecanico`.`vehiculos` (`id`, `anio`, `color`, `marca`, `modelo`, `patente`) VALUES ('1', '1111', 'Rojo', 'Fiat', 'Uno', 'AAA111');


/*Merge in table cliente_vehiculo*/

INSERT INTO `taller_mecanico`.`cliente_vehiculo` (`cliente_id`, `vehiculo_id`) VALUES ('1', '1');

/* Populate table empleados */

INSERT INTO `taller_mecanico`.`empleados` (`id`, `apellido`, `calle`, `celular`, `codigo_postal`, `departamento`, `localidad`, `nombres`, `numero`, `piso`, `tipo_empleado`) VALUES ('1', 'Nuñez', 'Calasanz', '155129748', '5107', 'Colon', 'Mendiolaza', 'Santiago', '2770', '1', 'RECEPCIONISTA');
INSERT INTO `taller_mecanico`.`empleados` (`id`, `apellido`, `calle`, `celular`, `codigo_postal`, `departamento`, `localidad`, `nombres`, `numero`, `piso`, `tipo_empleado`) VALUES ('2', 'Mendoza', 'Peatonal', '156158749', '5000', 'Colon', 'Cordoba', 'Carlos', '1550', '1', 'ADMINISTRATIVO');

/* Populate table mecanicos */

INSERT INTO `taller_mecanico`.`mecanicos` (`id`, `activo`, `apellido`, `calle`, `celular`, `codigo_postal`, `departamento`, `especialidad`, `localidad`, `nombres`, `numero`, `piso`) VALUES ('1', 'A', 'Gomez', 'Publica', '156894782', '5000', 'Cordoba', 'Generalista', 'Cordoba', 'Alberto', '35', '1');
