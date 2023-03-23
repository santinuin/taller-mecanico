package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.ManoObraDto;
import com.besysoft.taller_mecanico.business.dto.RepuestoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.ManoObraMapper;
import com.besysoft.taller_mecanico.business.mapper.interfaces.RepuestoMapper;
import com.besysoft.taller_mecanico.domain.entity.Repuesto;
import com.besysoft.taller_mecanico.service.interfaces.MecanicaService;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mecanica")
@Api(value = "Mecanica Controller", tags = "Acciones permitidas para Área de Mecánica")
public class MecanicaController {

    private final MecanicaService mecanicaService;
    private final ManoObraMapper manoObraMapper;
    private final RepuestoMapper repuestoMapper;

    public MecanicaController(MecanicaService mecanicaService, ManoObraMapper manoObraMapper, RepuestoMapper repuestoMapper) {
        this.mecanicaService = mecanicaService;
        this.manoObraMapper = manoObraMapper;
        this.repuestoMapper = repuestoMapper;
    }

    @GetMapping("/{mecanicoId}/asignaciones")
    @ApiOperation(value = "3.Ver asignaciones",
            tags = "Flujo de trabajo",
            notes = "Muestra aquellas Manos de Obra que fueron previamente asignadas por recepcion segun mecánico y esperan por reparacion")
    public ResponseEntity<?> listarManosDeObraAsignadas(@PathVariable Long mecanicoId) {

        List<ManoObraDto> manoObraDtoList = this.mecanicaService.listarManosDeObraAsignadas(mecanicoId)
                .stream()
                .map(this.manoObraMapper::toDto)
                .toList();

        return new ResponseEntity<>(manoObraDtoList, HttpStatus.OK);
    }

    @PutMapping("/{manoObraId}/iniciar")
    @ApiOperation(value = "4.Inicia Reparación",
            tags = "Flujo de trabajo",
            notes = "Elección de mano de obra para inicio de reparación del vehículo " +
                    "(se cambia de estado la orden de CREADA a EN_REPARACION)")
    public ResponseEntity<?> iniciarReparacion(@PathVariable Long manoObraId) {

        Map<String, Object> response = new HashMap<>();

        this.mecanicaService.iniciarReparacion(manoObraId);

        response.put("success", Boolean.TRUE);
        response.put("mensaje", "Mano de obra iniciada");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{manoObraId}/finalizar")
    @ApiOperation(value = "5.Finalizar reparación",
            tags = "Flujo de trabajo",
            notes = "A través del ID de la mano de obra, se completa detalle, " +
                    "duración de la reparación y, automáticamente, la hora de finalización")
    public ResponseEntity<?> finalizarReparacion(@PathVariable Long manoObraId,
                                                 @Valid @RequestBody ManoObraDto manoObraDto) {

        Map<String, Object> response = new HashMap<>();

        this.mecanicaService.finalizarReparacion(manoObraId, manoObraDto.getDetalle(), manoObraDto.getDuracionHs());

        response.put("success", Boolean.TRUE);
        response.put("mensaje", "Mano de obra completada con éxito");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{manoObraId}/cargar-repuesto")
    @ApiOperation(value = "6.Cargar repuestos ",
            tags = "Flujo de trabajo",
            notes = "Carga repuestos utilizados y valor de los mismos")
    public ResponseEntity<?> cargarRepuestos(@PathVariable Long manoObraId,
                                             @Valid @RequestBody RepuestoDto repuestoDto) {

        Map<String, Object> response = new HashMap<>();

        Repuesto repuesto = this.repuestoMapper.toEntity(repuestoDto);

        this.mecanicaService.cargarRepuestos(manoObraId, repuesto, repuestoDto.getCantidad());

        response.put("success", Boolean.TRUE);
        response.put("mensaje", "Repuesto cargado con éxito");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{manoObraId}/para-facturar")
    @ApiOperation(value = "7.Lista para facturar",
            tags = "Flujo de trabajo",
            notes = "EL mecanico da el visto bueno para que la orden pase a facturacion, cambia el estado a PARA_FACTURAR")
    public ResponseEntity<?> ordenParaFacturar(@PathVariable Long manoObraId) {

        Map<String, Object> response = new HashMap<>();

        this.mecanicaService.ordenParaFacturar(manoObraId);

        response.put("success", Boolean.TRUE);
        response.put("mensaje", "Orden lista para facturar");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
