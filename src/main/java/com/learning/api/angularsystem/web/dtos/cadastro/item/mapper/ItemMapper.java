package com.learning.api.angularsystem.web.dtos.cadastro.item.mapper;

import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemResponseDto;
import com.learning.api.angularsystem.entitys.cadastro.item.ItemEntity;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {
    public static ItemEntity toItem(ItemDto itemDto){
        return new ModelMapper().map(itemDto, ItemEntity.class);
    }

    public static ItemResponseDto toDto(ItemEntity item){
        return new ModelMapper().map(item,ItemResponseDto.class);
    }

    public static List<ItemResponseDto> toListDto(List<ItemEntity> itens){
        return itens.stream().map(item -> toDto(item)).collect(Collectors.toList());
    }
}
