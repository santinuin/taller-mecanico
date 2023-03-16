package com.besysoft.taller_mecanico.business.mapper.implementations;

import com.besysoft.taller_mecanico.business.dto.ClienteDto;
import com.besysoft.taller_mecanico.business.dto.VehiculoDto;
import com.besysoft.taller_mecanico.business.mapper.interfaces.ClienteMapper;
import com.besysoft.taller_mecanico.business.mapper.interfaces.VehiculoMapper;
import com.besysoft.taller_mecanico.domain.entity.Cliente;
import com.besysoft.taller_mecanico.domain.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Autowired
    private VehiculoMapper vehiculoMapper;

    @Override
    public Cliente toEntity(ClienteDto clienteDto) {
        if (clienteDto == null) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setVehiculos(vehiculoDtoListToVehiculoList(clienteDto.getVehiculos()));
        cliente.setId(clienteDto.getId());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setCelular(clienteDto.getCelular());
        cliente.setCalle(clienteDto.getCalle());
        cliente.setCodigoPostal(clienteDto.getCodigoPostal());
        cliente.setDepartamento(clienteDto.getDepartamento());
        cliente.setLocalidad(clienteDto.getLocalidad());
        cliente.setNumero(clienteDto.getNumero());
        cliente.setPiso(clienteDto.getPiso());
        cliente.setCorreoElectronico(clienteDto.getCorreoElectronico());
        cliente.setNombres(clienteDto.getNombres());
        cliente.setTelefonoLinea(clienteDto.getTelefonoLinea());

        return cliente;
    }

    @Override
    public ClienteDto toDto(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setId(cliente.getId());
        clienteDto.setApellido(cliente.getApellido());
        clienteDto.setCelular(cliente.getCelular());
        clienteDto.setCalle(cliente.getCalle());
        clienteDto.setCodigoPostal(cliente.getCodigoPostal());
        clienteDto.setDepartamento(cliente.getDepartamento());
        clienteDto.setLocalidad(cliente.getLocalidad());
        clienteDto.setNumero(cliente.getNumero());
        clienteDto.setPiso(cliente.getPiso());
        clienteDto.setCorreoElectronico(cliente.getCorreoElectronico());
        clienteDto.setNombres(cliente.getNombres());
        clienteDto.setTelefonoLinea(cliente.getTelefonoLinea());
        clienteDto.setVehiculos(vehiculoListToVehiculoDtoList(cliente.getVehiculos()));

        return clienteDto;
    }

    protected List<Vehiculo> vehiculoDtoListToVehiculoList(List<VehiculoDto> list) {
        if (list == null) {
            return null;
        }

        List<Vehiculo> list1 = new ArrayList<Vehiculo>(list.size());
        for (VehiculoDto vehiculoDto : list) {
            list1.add(vehiculoMapper.toEntity(vehiculoDto));
        }

        return list1;
    }

    protected List<VehiculoDto> vehiculoListToVehiculoDtoList(List<Vehiculo> list) {
        if (list == null) {
            return null;
        }

        List<VehiculoDto> list1 = new ArrayList<VehiculoDto>(list.size());
        for (Vehiculo vehiculo : list) {
            list1.add(vehiculoMapper.toDto(vehiculo));
        }

        return list1;
    }
}