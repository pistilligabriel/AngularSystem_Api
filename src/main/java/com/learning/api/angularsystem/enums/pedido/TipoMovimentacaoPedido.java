package com.learning.api.angularsystem.enums.pedido;

import lombok.Getter;

@Getter
public enum TipoMovimentacaoPedido {

    ENTREGUE("Entregue"),
    RETIRADO("Retirado"),
    ENVIADO("Enviado"),
    DEVOLVIDO("Devolvido"),
    PARCIAL("Parcial"),
    TRANSFERENCIA("Transferência"),
    OUTROS("Outros");

    private final String descricao;

    TipoMovimentacaoPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
