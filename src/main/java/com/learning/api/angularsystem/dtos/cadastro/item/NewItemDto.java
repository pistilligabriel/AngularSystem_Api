package com.learning.api.angularsystem.dtos.cadastro.item;

public class NewItemDto {

    private final Long CODIGO;

    public NewItemDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
