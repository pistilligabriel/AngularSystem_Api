package com.learning.api.angularsystem.enums.pedido;

public enum StatusPedido {

    PEDIDO("Pedido"),
    ORCAMENTO("Orçamento"),
    FATURADO("Faturado"),
    CONDICIONAL("Condicional"),
    COTACAO("Cotação"),
    CONCLUIDO("Concluído"),
    FINALIZADO("Finalizado");


    private final String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
