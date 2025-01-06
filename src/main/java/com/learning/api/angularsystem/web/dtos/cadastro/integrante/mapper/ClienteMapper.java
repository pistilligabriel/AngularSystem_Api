package com.learning.api.angularsystem.web.dtos.cadastro.integrante.mapper;

import com.learning.api.angularsystem.web.dtos.cadastro.integrante.ClienteDto;
import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import com.learning.api.angularsystem.web.dtos.cadastro.integrante.ClienteResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {



    public static Cliente toCliente(ClienteDto dto){
        return new ModelMapper().map(dto, Cliente.class);
    }

    public static ClienteResponseDto toDto(Cliente cliente){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return new ModelMapper().map(cliente,ClienteResponseDto.class);
    }

    public static List<ClienteResponseDto> toListDto(List<Cliente> clientes){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return clientes.stream().map(cliente -> toDto(cliente)).collect(Collectors.toList());
    }

}
