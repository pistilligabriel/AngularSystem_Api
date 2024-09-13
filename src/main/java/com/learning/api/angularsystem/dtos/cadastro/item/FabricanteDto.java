package com.learning.api.angularsystem.dtos.cadastro.item;

import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.entitys.cadastro.item.FabricanteEntity;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record FabricanteDto(

        Long CODIGO,

        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,

        @Enumerated
        Status status,

        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,

        LocalDateTime versao
) {

    public FabricanteDto(FabricanteEntity fabricanteEntity) {
        this(fabricanteEntity.getCODIGO(),
                fabricanteEntity.getDescricao(),
                fabricanteEntity.getStatus(),
                fabricanteEntity.getEmpresa(),
                fabricanteEntity.getVersao());
    }
}
