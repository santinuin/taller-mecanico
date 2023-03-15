package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.ClienteDto;
import com.besysoft.taller_mecanico.business.mapper.ClienteMapper;
import com.besysoft.taller_mecanico.domain.entity.Cliente;
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

    public EmpleadoController(EmpleadoService service, ClienteMapper clienteMapper) {
        this.service = service;
        this.clienteMapper = clienteMapper;
    }


    @PostMapping("/{id}/recibir")
    public ResponseEntity<?> recibir(@PathVariable Long id,
                                     @RequestBody ClienteDto clienteDto) {

        Map<String, Object> response = new HashMap<>();
        Cliente cliente = this.clienteMapper.toEntity(clienteDto);

        try {
            service.recibirClienteYVehiculo(id, cliente);
        } catch (InvalidRolException e) {
            response.put("mensaje", "Error al recibir vehiculo y cliente");
            response.put("error", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

        response.put("succes", Boolean.TRUE);
        response.put("mensaje", "Se ha recibido cliente y vehículo con exito");

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
