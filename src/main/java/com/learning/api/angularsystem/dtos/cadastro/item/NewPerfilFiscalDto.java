package com.learning.api.angularsystem.dtos.cadastro.item;

public class NewPerfilFiscalDto {

    private final Long CODIGO;

    public NewPerfilFiscalDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
