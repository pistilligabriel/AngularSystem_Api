package com.learning.api.angularsystem.web.dtos.cadastro.item.mapper;

import com.learning.api.angularsystem.entitys.cadastro.item.FabricanteEntity;
import com.learning.api.angularsystem.entitys.cadastro.item.ItemGrupoEntity;
import com.learning.api.angularsystem.web.dtos.cadastro.item.FabricanteDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.FabricanteResponseDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemGrupoDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemGrupoResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ItemGrupoMapper {
    public static ItemGrupoEntity toItemGrupo(ItemGrupoDto itemGrupoDto){
        return new ModelMapper().map(itemGrupoDto,ItemGrupoEntity.class);
    }

    public static ItemGrupoResponseDto toDto(ItemGrupoEntity itemGrupo){
        return new ModelMapper().map(itemGrupo,ItemGrupoResponseDto.class);
    }

    public static List<ItemGrupoResponseDto> toListDto(List<ItemGrupoEntity> itemGrupos){
        return itemGrupos.stream().map(itemGrupo -> toDto(itemGrupo)).collect(Collectors.toList());
    }
}
