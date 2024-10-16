package com.learning.api.angularsystem.web.dtos.cadastro.item.mapper;

import com.learning.api.angularsystem.web.dtos.cadastro.item.FabricanteDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.FabricanteResponseDto;
import com.learning.api.angularsystem.entitys.cadastro.item.FabricanteEntity;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class FabricanteMapper {
    public static FabricanteEntity toFabricante(FabricanteDto fabricanteDto){
        return new ModelMapper().map(fabricanteDto,FabricanteEntity.class);
    }

    public static FabricanteResponseDto toDto(FabricanteEntity fabricante){
        return new ModelMapper().map(fabricante,FabricanteResponseDto.class);
    }

    public static List<FabricanteResponseDto> toListDto(List<FabricanteEntity> fabricantes){
        return fabricantes.stream().map(fabricante -> toDto(fabricante)).collect(Collectors.toList());
    }
}
