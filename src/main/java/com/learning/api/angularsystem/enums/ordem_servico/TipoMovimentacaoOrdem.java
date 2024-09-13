package com.learning.api.angularsystem.enums.ordem_servico;

public enum TipoMovimentacaoOrdem {

    ENTREGE("Entregue"),
    RETIRADO("Retirado"),
    PARCIAL("Parcial");

    private final String descricao;

    TipoMovimentacaoOrdem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
