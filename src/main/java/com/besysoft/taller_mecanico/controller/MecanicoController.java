package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.MecanicoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.MecanicoMapper;
import com.besysoft.taller_mecanico.domain.entity.Mecanico;
import com.besysoft.taller_mecanico.service.interfaces.MecanicoService;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mecanicos")
@Api(value = "Mecanico Controller", tags = "Acciones permitidas para entidad Mecanico")
public class MecanicoController {

    private final MecanicoService mecanicoService;
    private final MecanicoMapper mecanicoMapper;

    public MecanicoController(MecanicoService mecanicoService, MecanicoMapper mecanicoMapper) {
        this.mecanicoService = mecanicoService;
        this.mecanicoMapper = mecanicoMapper;
    }

    @GetMapping
    @ApiOperation(value = "Listar Mecánicos")
    public ResponseEntity<?> findAll() {

        List<MecanicoDto> mecanicoDtoList = this.mecanicoService.findAll()
                .stream()
                .map(this.mecanicoMapper::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(mecanicoDtoList, HttpStatus.OK);
    }

    @PostMapping("/alta")
    @ApiOperation(value = "Alta de Mecánico")
    public ResponseEntity<?> altaMecanico(@Valid @RequestBody MecanicoDto mecanicoDto) {

        Map<String, Object> response = new HashMap<>();

        Mecanico nuevoMecanico = this.mecanicoService.alta(this.mecanicoMapper.toEntity(mecanicoDto));

        response.put("mensaje", "El mecánico ha sido creado con éxito");
        response.put("mecanico", nuevoMecanico);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/baja/{id}")
    @ApiOperation(value = "Baja de Mecánico")
    public ResponseEntity<?> bajaMecanico(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        this.mecanicoService.bajaById(id);

        response.put("mensaje", "El mecánico ha sido eliminado");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
