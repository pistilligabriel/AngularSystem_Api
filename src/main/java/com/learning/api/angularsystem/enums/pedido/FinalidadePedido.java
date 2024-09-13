package com.learning.api.angularsystem.enums.pedido;

public enum FinalidadePedido {

    BRINDE("Brinde"),
    COMSUMO("Consumo"),
    DEVOLUCAO("Devolução"),
    DOACAO("Doação"),
    NORMAL("Normal"),
    REPOSICAO("Reposição"),
    TROCA("Troca"),
    GARANTIA("Garantia"),
    AMOSTRA("Amostra"),
    OUTROS("Outros");

    private final String descricao;

    FinalidadePedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
