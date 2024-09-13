package com.learning.api.angularsystem.dtos.financeiro.titulo;

public class NewTituloDto {

    private final Long CODIGO;

    public NewTituloDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
