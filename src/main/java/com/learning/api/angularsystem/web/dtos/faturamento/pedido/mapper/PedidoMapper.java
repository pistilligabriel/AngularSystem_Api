package com.learning.api.angularsystem.web.dtos.faturamento.pedido.mapper;

import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.entitys.faturamento.pedido.Pedido;
import com.learning.api.angularsystem.entitys.faturamento.pedido.PedidoDetalhe;
import com.learning.api.angularsystem.web.dtos.cadastro.integrante.ClienteDto;
import com.learning.api.angularsystem.web.dtos.cadastro.integrante.ClienteResponseDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemDto;
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

    public static PedidoDto toPedidoDto(Pedido pedido) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        PedidoDto dto = modelMapper.map(pedido, PedidoDto.class);

        if (pedido.getDetalhes() != null) {
            List<ItemDto> produtos = pedido.getDetalhes().stream()
                    .map(detalhe -> {
                        Item item = detalhe.getItem();
                        ItemDto itemDto = new ItemDto();

                        itemDto.setCodigo(item.getCodigo());
                        itemDto.setDescricao(item.getDescricao());
                        itemDto.setModelo(item.getModelo());
                        itemDto.setObservacao(item.getObservacao());
                        itemDto.setPrecoVenda(detalhe.getValorUnitario());
                        itemDto.setQuantidade(detalhe.getQuantidade());
                        itemDto.setUnidadeVenda(
                                item.getUnidadeVenda() != null ? item.getUnidadeVenda().getCodigo() : null
                        );
                        itemDto.setFabricante(
                                item.getFabricante() != null ? item.getFabricante().getCodigo() : null
                        );
                        itemDto.setEstoque(item.getEstoque());
                        itemDto.setPrecoCusto(item.getPrecoCusto());
                        itemDto.setMargemLucro(item.getMargemLucro());

                        return itemDto;
                    })
                    .collect(Collectors.toList());

            dto.setProdutos(produtos);
        }
        return dto;
    }

    public static List<ResponsePedidoDto> toResponseListDto(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(pedido -> new ResponsePedidoDto(
                        pedido.getCodigo(),
                        toPedidoDto(pedido) // <-- usa o método manual, não o do ModelMapper direto
                ))
                .collect(Collectors.toList());
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
