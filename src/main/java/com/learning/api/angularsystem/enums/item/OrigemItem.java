package com.learning.api.angularsystem.enums.item;

import lombok.Getter;

@Getter
public enum OrigemItem {

    NACIONAL("Nacional"),
    IMPORTADO("Importado");

    private final String descricao;

    OrigemItem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
