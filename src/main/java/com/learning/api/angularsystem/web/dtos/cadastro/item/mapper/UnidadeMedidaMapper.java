package com.learning.api.angularsystem.web.dtos.cadastro.item.mapper;

import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedida;
import com.learning.api.angularsystem.web.dtos.cadastro.item.UnidadeMedidaDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.UnidadeMedidaResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UnidadeMedidaMapper {

    public static UnidadeMedida toUnidadeMedida(UnidadeMedidaDto unidadeDto){
        return new ModelMapper().map(unidadeDto, UnidadeMedida.class);
    }

    public static UnidadeMedidaResponseDto toDto(UnidadeMedida unidade){
        return new ModelMapper().map(unidade,UnidadeMedidaResponseDto.class);
    }

    public static List<UnidadeMedidaResponseDto> toListDto(List<UnidadeMedida> unidades){
        return unidades.stream().map(unidade -> toDto(unidade)).collect(Collectors.toList());
    }
}
