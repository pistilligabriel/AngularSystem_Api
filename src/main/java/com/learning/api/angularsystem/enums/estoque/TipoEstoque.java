package com.learning.api.angularsystem.enums.estoque;

public enum TipoEstoque {

    ENTRADA("Entrada"),
    SAIDA("Saída");

    private final String descricao;

    TipoEstoque(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
