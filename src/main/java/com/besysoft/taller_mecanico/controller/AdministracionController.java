package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.FormaPagoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.FormaPagoMapper;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;
import com.besysoft.taller_mecanico.service.interfaces.AdministracionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/administracion")
public class AdministracionController {

    private final AdministracionService administracionService;
    private final FormaPagoMapper formaPagoMapper;

    public AdministracionController(AdministracionService administracionService, FormaPagoMapper formaPagoMapper) {
        this.administracionService = administracionService;
        this.formaPagoMapper = formaPagoMapper;
    }

    @PutMapping("/{empleadoId}/facturar")
    public ResponseEntity<?> facturar(@PathVariable Long empleadoId,
                                     @RequestBody FormaPagoDto formaPagoDto){

        Map<String, Object> response = new HashMap<>();
        OrdenTrabajo ordenTrabajo = formaPagoMapper.toEntity(formaPagoDto);

        try {
            this.administracionService.facturar(empleadoId, ordenTrabajo);
        } catch (InvalidRolException e) {

            response.put("mensaje", "Error al facturar");
            response.put("error", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        response.put("succes", Boolean.TRUE);
        response.put("mensaje", "Facturacion exitosa");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
