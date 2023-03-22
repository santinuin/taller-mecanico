package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.FormaPagoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.FormaPagoMapper;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;
import com.besysoft.taller_mecanico.service.interfaces.AdministracionService;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Administracion Controller", tags = "Acciones permitidas para Área Administración")
public class AdministracionController {

    private final AdministracionService administracionService;
    private final FormaPagoMapper formaPagoMapper;

    public AdministracionController(AdministracionService administracionService, FormaPagoMapper formaPagoMapper) {
        this.administracionService = administracionService;
        this.formaPagoMapper = formaPagoMapper;
    }

    @PutMapping("/{empleadoId}/facturar")
    @ApiOperation(value = "8.Facturar",
            tags = "Flujo de trabajo",
            notes = "Se cambia estado de orden a facturada, se registra el empleado administrativo, pago y forma de pago")
    public ResponseEntity<?> facturar(@PathVariable Long empleadoId,
                                      @Valid @RequestBody FormaPagoDto formaPagoDto) throws InvalidRolException {

        Map<String, Object> response = new HashMap<>();
        OrdenTrabajo ordenTrabajo = formaPagoMapper.toEntity(formaPagoDto);

        this.administracionService.facturar(empleadoId, ordenTrabajo);

        response.put("success", Boolean.TRUE);
        response.put("mensaje", "Facturacion exitosa");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
