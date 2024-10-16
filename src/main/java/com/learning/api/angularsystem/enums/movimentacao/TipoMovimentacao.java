package com.learning.api.angularsystem.enums.movimentacao;

import lombok.Getter;

@Getter
public enum TipoMovimentacao {

    ENTRADA("Entrada"),
    SAIDA("Saída");

    private final String descricao;

    TipoMovimentacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
