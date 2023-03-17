package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.ClienteDto;
import com.besysoft.taller_mecanico.business.dto.OrdenTrabajoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.ClienteMapper;
import com.besysoft.taller_mecanico.business.mapper.interfaces.OrdenTrabajoMapper;
import com.besysoft.taller_mecanico.domain.entity.Cliente;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;
import com.besysoft.taller_mecanico.service.interfaces.RecepcionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/recepcion")
public class RecepcionController {

        private final RecepcionService recepcionService;
        private final ClienteMapper clienteMapper;
        private final OrdenTrabajoMapper ordenTrabajoMapper;

    public RecepcionController(RecepcionService recepcionService, ClienteMapper clienteMapper, OrdenTrabajoMapper ordenTrabajoMapper) {
        this.recepcionService = recepcionService;
        this.clienteMapper = clienteMapper;
        this.ordenTrabajoMapper = ordenTrabajoMapper;
    }


    @PostMapping("/{empleadoId}/recibir")
    public ResponseEntity<?> recibir(@PathVariable Long empleadoId,
                                     @RequestBody ClienteDto clienteDto) {

        Map<String, Object> response = new HashMap<>();
        Cliente cliente = this.clienteMapper.toEntity(clienteDto);

        try {
            recepcionService.recibirClienteYVehiculo(empleadoId, cliente);
        } catch (InvalidRolException e) {
            response.put("mensaje", "Error al recibir vehiculo y cliente");
            response.put("error", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
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
            this.recepcionService.generarOrdenDeTrabajo(empleadoId,
                    ordenTrabajo.getNivelCombustible(),
                    ordenTrabajo.getKilometraje(),
                    ordenTrabajo.getDetalleFalla(),
                    ordenTrabajo.getVehiculo().getPatente(),
                    ordenTrabajoDto.getMecanicoId());

        } catch (InvalidRolException e) {
            response.put("mensaje", "Error al generar orden de trabajo");
            response.put("error", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        response.put("succes", Boolean.TRUE);
        response.put("mensaje", "Se ha generado orden de trabajo con exito");

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PutMapping("/{empleadoId}/entregar/{ordenTrabajoId}")
    public ResponseEntity<?> entregarVehiculo(@PathVariable Long empleadoId,
                                 @PathVariable Long ordenTrabajoId){

        Map<String, Object> response = new HashMap<>();

        try {
            this.recepcionService.entregarVehiculo(empleadoId, ordenTrabajoId);
        } catch (InvalidRolException e) {
            response.put("mensaje", "Error al generar orden de trabajo");
            response.put("error", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }


        response.put("succes", Boolean.TRUE);
        response.put("mensaje", "Entrega de vehiculo exitosa");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
