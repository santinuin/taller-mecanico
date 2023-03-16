package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.VehiculoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.VehiculoMapper;
import com.besysoft.taller_mecanico.service.interfaces.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    private final VehiculoService vehiculoService;
    private final VehiculoMapper vehiculoMapper;

    public VehiculoController(VehiculoService vehiculoService, VehiculoMapper vehiculoMapper) {
        this.vehiculoService = vehiculoService;
        this.vehiculoMapper = vehiculoMapper;
    }

    @GetMapping
    public ResponseEntity<List<VehiculoDto>> findAll() {
        List<VehiculoDto> vehiculoDtoList = this.vehiculoService.findAll()
                .stream()
                .map(this.vehiculoMapper::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(vehiculoDtoList, HttpStatus.OK);
    }
}
