package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.EmpleadoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.EmpleadoMapper;
import com.besysoft.taller_mecanico.domain.entity.Empleado;
import com.besysoft.taller_mecanico.service.interfaces.EmpleadoService;

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
@RequestMapping("/empleados")
@Api(value = "Empleado Controller", tags = "Acciones permitidas para entidad Empleado")
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    private final EmpleadoMapper empleadoMapper;

    public EmpleadoController(EmpleadoService empleadoService, EmpleadoMapper empleadoMapper) {
        this.empleadoService = empleadoService;
        this.empleadoMapper = empleadoMapper;
    }

    @GetMapping
    @ApiOperation(value = "Listar Empleados")
    public ResponseEntity<?> findAll() {

        List<EmpleadoDto> empleadoDtoList = this.empleadoService.findAll()
                .stream()
                .map(this.empleadoMapper::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(empleadoDtoList, HttpStatus.OK);
    }

    @PostMapping("/alta")
    @ApiOperation(value = "Alta de empleado")
    public ResponseEntity<?> altaEmpleado(@Valid @RequestBody EmpleadoDto empleadoDto) {

        Map<String, Object> response = new HashMap<>();

        Empleado nuevoEmpleado = this.empleadoService.alta(this.empleadoMapper.toEntity(empleadoDto));

        response.put("mensaje", "El empleado ha sido creado con éxito");
        response.put("empleado", nuevoEmpleado);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/baja/{id}")
    @ApiOperation(value = "Baja de empleado")
    public ResponseEntity<?> bajaEmpleado(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        this.empleadoService.bajaById(id);

        response.put("mensaje", "El empleado ha sido eliminado");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
