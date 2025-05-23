package com.learning.api.angularsystem.web.dtos.cadastro.item.mapper;

import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Item toItem(ItemDto itemDto) {
        return new ModelMapper().map(itemDto, Item.class);
    }

    public static ItemResponseDto toDto(Item item) {
        ItemResponseDto dto = modelMapper.map(item, ItemResponseDto.class);

//        // Se o Item tiver unidadeVenda, pega o símbolo ou outro atributo desejado
//        if (item.getUnidadeVenda() != null) {
//            dto.setUnidadeVenda(item.getUnidadeVenda().getCodigo()); // Mapeia apenas o símbolo ou o nome
//        }

//        // Se o Item tiver fabricante, pega o nome ou outro atributo desejado
//        if (item.getFabricante() != null) {
//            dto.setFabricante(item.getFabricante().getCodigo()); // Mapeia o nome ou o código do fabricante
//        }

//        if(item.getGrupoItem() != null) {
//            dto.setGrupoItem(item.getGrupoItem().getCodigo()); // Mapeia o código do grupo de item
//    }
        // Se precisar de mais campos, mapeie de forma similar
        return dto;


    }

    public static List<ItemResponseDto> toListDto(List<Item> itens){
        return itens.stream().map(item -> toDto(item)).collect(Collectors.toList());
    }
}
