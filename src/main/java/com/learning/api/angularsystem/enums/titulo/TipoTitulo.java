package com.learning.api.angularsystem.enums.titulo;

import lombok.Getter;

@Getter
public enum TipoTitulo {

    PAGAR("Pagar"),
    RECEBER("Receber");

    private final String descricao;

    TipoTitulo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
