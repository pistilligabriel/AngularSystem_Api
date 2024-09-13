package com.learning.api.angularsystem.dtos.cadastro.item;

public class NewFabricanteDto {

    private final Long CODIGO;

    public NewFabricanteDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
