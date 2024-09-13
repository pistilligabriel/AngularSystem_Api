package com.learning.api.angularsystem.dtos.cadastro.integrante;

public class NewIntegranteDto {

    private final Long CODIGO;

    public NewIntegranteDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
