package com.learning.api.angularsystem.enums.movimentacao;

import lombok.Getter;

@Getter
public enum Tipo {

    CAIXA("Caixa"),
    BANCO("Banco");

    private final String descricao;

    Tipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
