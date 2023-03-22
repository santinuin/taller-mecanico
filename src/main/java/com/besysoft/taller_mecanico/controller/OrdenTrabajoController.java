package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.OrdenTrabajoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.OrdenTrabajoMapper;
import com.besysoft.taller_mecanico.service.interfaces.ManoObraService;
import com.besysoft.taller_mecanico.service.interfaces.OrdenTrabajoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orden")
public class OrdenTrabajoController {

    private final OrdenTrabajoService ordenTrabajoService;
    private final OrdenTrabajoMapper ordenTrabajoMapper;

    public OrdenTrabajoController(OrdenTrabajoService ordenTrabajoService, OrdenTrabajoMapper ordenTrabajoMapper) {
        this.ordenTrabajoService = ordenTrabajoService;
        this.ordenTrabajoMapper = ordenTrabajoMapper;
    }

    @GetMapping
    public ResponseEntity<List<OrdenTrabajoDto>> findAll() {

        List<OrdenTrabajoDto> ordenTrabajoDtoList = this.ordenTrabajoService.findAll()
                .stream()
                .map(this.ordenTrabajoMapper::toDto)
                .toList();

        return new ResponseEntity<>(ordenTrabajoDtoList, HttpStatus.OK);
    }
}
