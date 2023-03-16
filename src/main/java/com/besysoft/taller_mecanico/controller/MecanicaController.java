package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.ManoObraDto;
import com.besysoft.taller_mecanico.business.dto.RepuestoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.ManoObraMapper;
import com.besysoft.taller_mecanico.business.mapper.interfaces.RepuestoMapper;
import com.besysoft.taller_mecanico.domain.entity.Repuesto;
import com.besysoft.taller_mecanico.service.interfaces.MecanicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mecanica")
public class MecanicaController {

    private final MecanicaService mecanicaService;
    private final ManoObraMapper manoObraMapper;
    private final RepuestoMapper repuestoMapper;

    public MecanicaController(MecanicaService mecanicaService, ManoObraMapper manoObraMapper, RepuestoMapper repuestoMapper) {
        this.mecanicaService = mecanicaService;
        this.manoObraMapper = manoObraMapper;
        this.repuestoMapper = repuestoMapper;
    }

    @GetMapping
    @RequestMapping("/{mecanicoId}/asignaciones")
    public ResponseEntity<?> listarManosDeObraAsignadas(@PathVariable Long mecanicoId) {

        List<ManoObraDto> manoObraDtoList = this.mecanicaService.listarManosDeObraAsignadas(mecanicoId)
                .stream()
                .map(this.manoObraMapper::toDto)
                .toList();

        return new ResponseEntity<>(manoObraDtoList, HttpStatus.OK);
    }

    @PutMapping
    @RequestMapping("/{manoObraId}/iniciar")
    public ResponseEntity<?> iniciarReparacion(@PathVariable Long manoObraId){

        Map<String, Object> response = new HashMap<>();

        this.mecanicaService.iniciarReparacion(manoObraId);

        response.put("succes", Boolean.TRUE);
        response.put("mensaje", "Mano de obra iniciada");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    @RequestMapping("/{manoObraId}/finalizar")
    public ResponseEntity<?> finalizarReparacion(@PathVariable Long manoObraId,
                                                 @RequestBody ManoObraDto manoObraDto) {

        Map<String, Object> response = new HashMap<>();

        this.mecanicaService.finalizarReparacion(manoObraId, manoObraDto.getDetalle(), manoObraDto.getDuracionHs());

        response.put("succes", Boolean.TRUE);
        response.put("mensaje", "Mano de obra completada con éxito");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("/{manoObraId}/cargar-repuesto")
    public ResponseEntity<?> cargarRepuestos(@PathVariable Long manoObraId,
                                             @RequestBody RepuestoDto repuestoDto) {

        Map<String, Object> response = new HashMap<>();

        Repuesto repuesto = this.repuestoMapper.toEntity(repuestoDto);

        this.mecanicaService.cargarRepuestos(manoObraId, repuesto);

        response.put("succes", Boolean.TRUE);
        response.put("mensaje", "Repuesto cargado con éxito");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    @RequestMapping("/{manoObraId}/para-facturar")
    public ResponseEntity<?> ordenParaFacturar(@PathVariable Long manoObraId) {

        Map<String, Object> response = new HashMap<>();

        this.mecanicaService.ordenParaFacturar(manoObraId);

        response.put("succes", Boolean.TRUE);
        response.put("mensaje", "Orden lista para facturar");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
