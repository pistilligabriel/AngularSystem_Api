package com.learning.api.angularsystem.dtos.faturamento.estoque;

public class NewEstoqueDto {

    private final Long CODIGO;

    public NewEstoqueDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
