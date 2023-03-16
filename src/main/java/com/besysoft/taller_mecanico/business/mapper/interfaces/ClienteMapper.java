package com.besysoft.taller_mecanico.business.mapper.interfaces;

import com.besysoft.taller_mecanico.business.dto.ClienteDto;
import com.besysoft.taller_mecanico.domain.entity.Cliente;

public interface ClienteMapper {
    Cliente toEntity(ClienteDto clienteDto);

    ClienteDto toDto(Cliente cliente);
}