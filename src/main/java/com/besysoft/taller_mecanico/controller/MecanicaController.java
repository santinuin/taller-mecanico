package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.ManoObraDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.ManoObraMapper;
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

    public MecanicaController(MecanicaService mecanicaService, ManoObraMapper manoObraMapper) {
        this.mecanicaService = mecanicaService;
        this.manoObraMapper = manoObraMapper;
    }

    @GetMapping
    @RequestMapping("/{mecanicoId}/mano-obra")
    public ResponseEntity<?> listarManosDeObraAsignadas(@PathVariable Long mecanicoId) {

        List<ManoObraDto> manoObraDtoList = this.mecanicaService.listarManosDeObraAsignadas(mecanicoId)
                .stream()
                .map(this.manoObraMapper::toDto)
                .toList();

        return new ResponseEntity<>(manoObraDtoList, HttpStatus.OK);
    }

    @PutMapping
    @RequestMapping("/{manoObraId}/generar")
    public ResponseEntity<?> completarManoObra(@PathVariable Long manoObraId,
                                               @RequestBody ManoObraDto manoObraDto){

        Map<String, Object> response = new HashMap<>();

        this.mecanicaService.completarManoObra(manoObraId, manoObraDto.getDetalle(), manoObraDto.getDuracionHs());

        response.put("succes", Boolean.TRUE);
        response.put("mensaje", "Mano de obra completada con éxito");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
