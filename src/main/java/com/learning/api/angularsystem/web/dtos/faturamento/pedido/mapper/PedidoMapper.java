package com.learning.api.angularsystem.web.dtos.faturamento.pedido.mapper;

import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import com.learning.api.angularsystem.entitys.faturamento.pedido.Pedido;
import com.learning.api.angularsystem.entitys.faturamento.pedido.PedidoDetalhe;
import com.learning.api.angularsystem.web.dtos.cadastro.integrante.ClienteDto;
import com.learning.api.angularsystem.web.dtos.cadastro.integrante.ClienteResponseDto;
import com.learning.api.angularsystem.web.dtos.faturamento.pedido.DetalheResponseDto;
import com.learning.api.angularsystem.web.dtos.faturamento.pedido.PedidoDetalheDto;
import com.learning.api.angularsystem.web.dtos.faturamento.pedido.PedidoDto;
import com.learning.api.angularsystem.web.dtos.faturamento.pedido.ResponsePedidoDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {
    public static Pedido toPedido(PedidoDto dto){
        return new ModelMapper().map(dto, Pedido.class);
    }

    public static ResponsePedidoDto toDto(Pedido pedido){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return new ModelMapper().map(pedido,ResponsePedidoDto.class);
    }

    public static List<ResponsePedidoDto> toListDto(List<Pedido> pedidos){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return pedidos.stream().map(pedido -> toDto(pedido)).collect(Collectors.toList());
    }

    public static PedidoDetalhe toDetalhe(PedidoDetalheDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(dto, PedidoDetalhe.class);
    }

    public static DetalheResponseDto toDto(PedidoDetalhe detalhe) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(detalhe, DetalheResponseDto.class);
    }

}
