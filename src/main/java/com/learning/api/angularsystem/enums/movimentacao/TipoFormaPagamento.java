package com.learning.api.angularsystem.enums.movimentacao;

import lombok.Getter;

@Getter
public enum TipoFormaPagamento {

    DINHEIRO("Dinheiro"),
    CARTAO_CREDITO_A_VISTA("Cartão de Crédito à Vista"),
    CARTAO_PARCELADO("Cartão Crédito Parcelado"),
    CARTAO_DEBITO("Cartão de Débito"),
    PIX("Pix");

    private final String descricao;

    TipoFormaPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
