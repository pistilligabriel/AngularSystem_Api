package com.learning.api.angularsystem.dtos.cadastro.integrante.table;

import com.learning.api.angularsystem.entitys.cadastro.integrante.IntegranteEntity;

public record IntegranteTableDto(

        Long CODIGO,

        String nome
) {

    public IntegranteTableDto(IntegranteEntity integranteEntity) {
        this(integranteEntity.getCODIGO(),
                integranteEntity.getNome());
    }
}
