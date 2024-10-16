package com.learning.api.angularsystem.web.dtos.financeiro.titulo.mapper;

import com.learning.api.angularsystem.entitys.financeiro.movimentacao.FormaPagamentoEntity;
import com.learning.api.angularsystem.entitys.financeiro.titulo.TituloEntity;
import com.learning.api.angularsystem.web.dtos.financeiro.movimentacao.FormaPagamentoDto;
import com.learning.api.angularsystem.web.dtos.financeiro.movimentacao.ResponseFormaPagamentoDto;
import com.learning.api.angularsystem.web.dtos.financeiro.titulo.TituloDto;
import com.learning.api.angularsystem.web.dtos.financeiro.titulo.TituloResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TituloMapper {

    public static TituloEntity toTitulo(TituloDto tituloDto){
        return new ModelMapper().map(tituloDto,TituloEntity.class);
    }

    public static TituloResponseDto toDto(TituloEntity titulo){
        return new ModelMapper().map(titulo,TituloResponseDto.class);
    }

    public static List<TituloResponseDto> toListDto(List<TituloEntity> titulos){
        return titulos.stream().map(titulo -> toDto(titulo)).collect(Collectors.toList());
    }

}
