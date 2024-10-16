package com.learning.api.angularsystem.web.dtos.cadastro.item.mapper;

import com.learning.api.angularsystem.entitys.cadastro.item.FabricanteEntity;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedidaEntity;
import com.learning.api.angularsystem.web.dtos.cadastro.item.FabricanteDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.FabricanteResponseDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.UnidadeMedidaDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.UnidadeMedidaResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UnidadeMedidaMapper {

    public static UnidadeMedidaEntity toUnidadeMedida(UnidadeMedidaDto unidadeDto){
        return new ModelMapper().map(unidadeDto,UnidadeMedidaEntity.class);
    }

    public static UnidadeMedidaResponseDto toDto(UnidadeMedidaEntity unidade){
        return new ModelMapper().map(unidade,UnidadeMedidaResponseDto.class);
    }

    public static List<UnidadeMedidaResponseDto> toListDto(List<UnidadeMedidaEntity> unidades){
        return unidades.stream().map(unidade -> toDto(unidade)).collect(Collectors.toList());
    }
}
