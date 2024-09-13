package com.learning.api.angularsystem.dtos.cadastro.item;

public class NewItemGrupoDto {

    private final Long CODIGO;

    public NewItemGrupoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
