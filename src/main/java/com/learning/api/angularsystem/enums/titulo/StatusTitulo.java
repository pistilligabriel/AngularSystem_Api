package com.learning.api.angularsystem.enums.titulo;

import lombok.Getter;

@Getter
public enum StatusTitulo {

    ABERTO("Aberto"),
    RECEBIDO("Recebido");

    private final String descricao;

    StatusTitulo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
