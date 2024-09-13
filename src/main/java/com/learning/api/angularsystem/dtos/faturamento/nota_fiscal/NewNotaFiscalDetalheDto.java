package com.learning.api.angularsystem.dtos.faturamento.nota_fiscal;

public class NewNotaFiscalDetalheDto {

    private final Long CODIGO;

    public NewNotaFiscalDetalheDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
