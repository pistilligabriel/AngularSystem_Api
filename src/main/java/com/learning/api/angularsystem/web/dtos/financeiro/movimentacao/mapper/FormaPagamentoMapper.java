package com.learning.api.angularsystem.web.dtos.financeiro.movimentacao.mapper;

import com.learning.api.angularsystem.entitys.financeiro.movimentacao.FormaPagamentoEntity;
import com.learning.api.angularsystem.web.dtos.financeiro.movimentacao.FormaPagamentoDto;
import com.learning.api.angularsystem.web.dtos.financeiro.movimentacao.ResponseFormaPagamentoDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class FormaPagamentoMapper {
    public static FormaPagamentoEntity toFormaPagamento(FormaPagamentoDto formaPagamentoDto){
        return new ModelMapper().map(formaPagamentoDto,FormaPagamentoEntity.class);
    }

    public static ResponseFormaPagamentoDto toDto(FormaPagamentoEntity formaPagamento){
        return new ModelMapper().map(formaPagamento,ResponseFormaPagamentoDto.class);
    }

    public static List<ResponseFormaPagamentoDto> toListDto(List<FormaPagamentoEntity> formasPagamento){
        return formasPagamento.stream().map(formaPagamento -> toDto(formaPagamento)).collect(Collectors.toList());
    }
}
