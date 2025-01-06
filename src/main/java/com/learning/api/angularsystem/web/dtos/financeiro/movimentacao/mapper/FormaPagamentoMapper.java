package com.learning.api.angularsystem.web.dtos.financeiro.movimentacao.mapper;

import com.learning.api.angularsystem.entitys.financeiro.movimentacao.FormaPagamento;
import com.learning.api.angularsystem.web.dtos.financeiro.movimentacao.FormaPagamentoDto;
import com.learning.api.angularsystem.web.dtos.financeiro.movimentacao.ResponseFormaPagamentoDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class FormaPagamentoMapper {
    public static FormaPagamento toFormaPagamento(FormaPagamentoDto formaPagamentoDto){
        return new ModelMapper().map(formaPagamentoDto, FormaPagamento.class);
    }

    public static ResponseFormaPagamentoDto toDto(FormaPagamento formaPagamento){
        return new ModelMapper().map(formaPagamento,ResponseFormaPagamentoDto.class);
    }

    public static List<ResponseFormaPagamentoDto> toListDto(List<FormaPagamento> formasPagamento){
        return formasPagamento.stream().map(formaPagamento -> toDto(formaPagamento)).collect(Collectors.toList());
    }
}
