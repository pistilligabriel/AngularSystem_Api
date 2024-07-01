package com.learning.api.minisys.dtos.cadastro.item;

import com.learning.api.minisys.entitys.cadastro.item.ItemEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ItemDto(

        Long CODIGO,

        LocalDateTime dataCadastro,

        NewItemGrupoDto grupoItem,

        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,

        String observacao,

        NewUnidadeMedidaDto unidadeVenda,

        NewFabricanteDto fabricante,

        String codigoBarras,

        String codigoOriginal,

        Double precoCusto,

        Double precoVenda,

        Double estoque,

        @Enumerated
        Status status,

        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,

        LocalDateTime versao
) {

    public ItemDto(ItemEntity itemEntity) {
        this(itemEntity.getCODIGO(),
                itemEntity.getDataCadastro(),
                itemEntity.getGrupoItem() != null ?
                    new NewItemGrupoDto(itemEntity.getGrupoItem().getCODIGO()): null,
                itemEntity.getDescricao(),
                itemEntity.getObservacao(),
                itemEntity.getUnidadeVenda() != null ?
                        new NewUnidadeMedidaDto(itemEntity.getUnidadeVenda().getCODIGO()) : null,
                itemEntity.getFabricante() != null ?
                        new NewFabricanteDto(itemEntity.getFabricante().getCODIGO()) : null,
                itemEntity.getCodigoBarras(),
                itemEntity.getCodigoOriginal(),
                itemEntity.getPrecoCusto(),
                itemEntity.getPrecoVenda(),
                itemEntity.getEstoque(),
                itemEntity.getStatus(),
                itemEntity.getEmpresa(),
                itemEntity.getVersao());
    }
}
