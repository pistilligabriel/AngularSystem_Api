package com.learning.api.angularsystem.enums.pedido;

import lombok.Getter;

@Getter
public enum FinalidadePedido {


    NORMAL("Normal");


    private final String descricao;

    FinalidadePedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
