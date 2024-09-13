package com.learning.api.angularsystem.dtos.financeiro.movimentacao;

public class NewFormaPagamentoDto {

    private final Long CODIGO;

    public NewFormaPagamentoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
