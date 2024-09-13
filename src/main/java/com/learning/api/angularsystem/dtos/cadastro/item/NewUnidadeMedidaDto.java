package com.learning.api.angularsystem.dtos.cadastro.item;

public class NewUnidadeMedidaDto {

    private final Long CODIGO;

    public NewUnidadeMedidaDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
