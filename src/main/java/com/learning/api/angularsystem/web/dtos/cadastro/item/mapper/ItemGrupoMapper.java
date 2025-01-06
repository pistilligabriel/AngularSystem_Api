package com.learning.api.angularsystem.web.dtos.cadastro.item.mapper;

import com.learning.api.angularsystem.entitys.cadastro.item.ItemGrupo;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemGrupoDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemGrupoResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ItemGrupoMapper {
    public static ItemGrupo toItemGrupo(ItemGrupoDto itemGrupoDto){
        return new ModelMapper().map(itemGrupoDto, ItemGrupo.class);
    }

    public static ItemGrupoResponseDto toDto(ItemGrupo itemGrupo){
        return new ModelMapper().map(itemGrupo,ItemGrupoResponseDto.class);
    }

    public static List<ItemGrupoResponseDto> toListDto(List<ItemGrupo> itemGrupos){
        return itemGrupos.stream().map(itemGrupo -> toDto(itemGrupo)).collect(Collectors.toList());
    }
}
