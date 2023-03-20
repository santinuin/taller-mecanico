package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.ManoObraDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.ManoObraMapper;
import com.besysoft.taller_mecanico.service.interfaces.ManoObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mano-obra")
public class ManoDeObraController {

    private final ManoObraService manoObraService;
    private final ManoObraMapper manoObraMapper;

    public ManoDeObraController(ManoObraService manoObraService, ManoObraMapper manoObraMapper) {
        this.manoObraService = manoObraService;
        this.manoObraMapper = manoObraMapper;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<ManoObraDto> manoObraDtoList = this.manoObraService.findAll()
                .stream()
                .map(this.manoObraMapper::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(manoObraDtoList, HttpStatus.OK);
    }
}
