package com.learning.api.angularsystem.enums.nota_fiscal;

public enum TipoNotaFiscal {

    ENTRADA("Entrada"),
    SAIDA("Saída"),
    SERVICO("Serviço");

    private final String descricao;

    TipoNotaFiscal(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
