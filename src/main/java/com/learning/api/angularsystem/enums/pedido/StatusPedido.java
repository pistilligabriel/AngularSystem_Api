package com.learning.api.angularsystem.enums.pedido;

import lombok.Getter;

@Getter
public enum StatusPedido {

    PEDIDO("Pedido"),
    FINALIZADO("Finalizado");


    private final String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
