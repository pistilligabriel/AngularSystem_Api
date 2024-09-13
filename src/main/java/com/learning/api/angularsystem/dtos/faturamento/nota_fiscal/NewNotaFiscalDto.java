package com.learning.api.angularsystem.dtos.faturamento.nota_fiscal;

public class NewNotaFiscalDto {

    private final Long CODIGO;

    public NewNotaFiscalDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
