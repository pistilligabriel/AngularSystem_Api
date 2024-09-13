package com.learning.api.angularsystem.dtos.cadastro.usuario;

public class NewUsuarioGrupoDto {

    private final Long CODIGO;

    public NewUsuarioGrupoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
