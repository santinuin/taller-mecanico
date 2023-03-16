package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.ClienteDto;
import com.besysoft.taller_mecanico.business.dto.OrdenTrabajoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.ClienteMapper;
import com.besysoft.taller_mecanico.business.mapper.interfaces.OrdenTrabajoMapper;
import com.besysoft.taller_mecanico.domain.entity.Cliente;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;
import com.besysoft.taller_mecanico.service.interfaces.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

        private final EmpleadoService service;
        private final ClienteMapper clienteMapper;
        private final OrdenTrabajoMapper ordenTrabajoMapper;

    public EmpleadoController(EmpleadoService service, ClienteMapper clienteMapper, OrdenTrabajoMapper ordenTrabajoMapper) {
        this.service = service;
        this.clienteMapper = clienteMapper;
        this.ordenTrabajoMapper = ordenTrabajoMapper;
    }


    @PostMapping("/{empleadoId}/recibir")
    public ResponseEntity<?> recibir(@PathVariable Long empleadoId,
                                     @RequestBody ClienteDto clienteDto) {

        Map<String, Object> response = new HashMap<>();
        Cliente cliente = this.clienteMapper.toEntity(clienteDto);

        try {
            service.recibirClienteYVehiculo(empleadoId, cliente);
        } catch (InvalidRolException e) {
            response.put("mensaje", "Error al recibir vehiculo y cliente");
            response.put("error", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

        response.put("succes", Boolean.TRUE);
        response.put("mensaje", "Se ha recibido cliente y vehículo con exito");

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PostMapping("/{empleadoId}/generar-orden")
    public ResponseEntity<?> generarOrden(@PathVariable Long empleadoId,
                                          @RequestBody OrdenTrabajoDto ordenTrabajoDto){

        Map<String, Object> response = new HashMap<>();
        OrdenTrabajo ordenTrabajo = this.ordenTrabajoMapper.toEntity(ordenTrabajoDto);

        try {
            service.generarOrdenDeTrabajo(empleadoId,
                    ordenTrabajo.getNivelCombustible(),
                    ordenTrabajo.getKilometraje(),
                    ordenTrabajo.getDetalleFalla(),
                    ordenTrabajo.getVehiculo().getPatente(),
                    ordenTrabajoDto.getMecanicoId());

        } catch (InvalidRolException e) {
            response.put("mensaje", "Error al generar orden de trabajo");
            response.put("error", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

        response.put("succes", Boolean.TRUE);
        response.put("mensaje", "Se ha generado orden de trabajo con exito");

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
