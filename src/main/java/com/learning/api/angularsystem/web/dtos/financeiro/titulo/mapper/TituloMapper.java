package com.learning.api.angularsystem.web.dtos.financeiro.titulo.mapper;

import com.learning.api.angularsystem.entitys.financeiro.titulo.Titulo;
import com.learning.api.angularsystem.web.dtos.financeiro.titulo.TituloDto;
import com.learning.api.angularsystem.web.dtos.financeiro.titulo.TituloResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TituloMapper {

    public static Titulo toTitulo(TituloDto tituloDto){
        return new ModelMapper().map(tituloDto, Titulo.class);
    }

    public static TituloResponseDto toDto(Titulo titulo){
        return new ModelMapper().map(titulo,TituloResponseDto.class);
    }

    public static List<TituloResponseDto> toListDto(List<Titulo> titulos){
        return titulos.stream().map(titulo -> toDto(titulo)).collect(Collectors.toList());
    }

}
