package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.business.dto.ClienteDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.ClienteMapper;
import com.besysoft.taller_mecanico.service.interfaces.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
@Api(value = "Cliente Controller", tags = "Acciones permitidas para entidad Cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    @GetMapping
    @ApiOperation(value = "Listar Clientes")
    public ResponseEntity<List<ClienteDto>> findAll() {

        List<ClienteDto> clienteDtoList = this.clienteService.findAll()
                .stream()
                .map(this.clienteMapper::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(clienteDtoList, HttpStatus.OK);
    }

}
