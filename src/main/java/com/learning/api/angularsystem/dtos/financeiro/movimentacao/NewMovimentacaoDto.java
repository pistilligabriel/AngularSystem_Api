package com.learning.api.angularsystem.dtos.financeiro.movimentacao;

public class NewMovimentacaoDto {

    private final Long CODIGO;

    public NewMovimentacaoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
