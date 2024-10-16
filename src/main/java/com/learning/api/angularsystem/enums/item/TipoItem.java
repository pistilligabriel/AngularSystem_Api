package com.learning.api.angularsystem.enums.item;

import lombok.Getter;

@Getter
public enum TipoItem {

    PRODUTO("Produto"),
    SERVICO("Serviço");

    private final String descricao;

    TipoItem(String descricao) {
        this.descricao = descricao;
    }

    public String descricao() {
        return this.descricao;
    }
}
