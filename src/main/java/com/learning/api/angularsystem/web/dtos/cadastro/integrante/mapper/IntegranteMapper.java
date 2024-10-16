package com.learning.api.angularsystem.web.dtos.cadastro.integrante.mapper;

import com.learning.api.angularsystem.web.dtos.cadastro.integrante.IntegranteDto;
import com.learning.api.angularsystem.web.dtos.cadastro.integrante.IntegranteResponseDto;
import com.learning.api.angularsystem.entitys.cadastro.integrante.IntegranteEntity;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class IntegranteMapper {
    public static IntegranteEntity toIntegrante(IntegranteDto dto){
        return new ModelMapper().map(dto, IntegranteEntity.class);
    }

    public static IntegranteResponseDto toDto(IntegranteEntity integrante){
        return new ModelMapper().map(integrante,IntegranteResponseDto.class);
    }

    public static List<IntegranteResponseDto> toListDto(List<IntegranteEntity> integrantes){
        return integrantes.stream().map(integrante -> toDto(integrante)).collect(Collectors.toList());
    }

}
