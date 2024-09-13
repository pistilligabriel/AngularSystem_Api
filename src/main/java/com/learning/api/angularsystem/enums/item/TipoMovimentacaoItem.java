package com.learning.api.angularsystem.enums.item;

public enum TipoMovimentacaoItem {

    COMPRA("Tipo Compra"),
    VENDA("Tipo Venda"),
    EQUIPAMENTO("Equipamento"),
    FERRAMENTA("Ferramenta"),
    MATERIAL("Material"),
    PRODUTO_ACABADO("Produto Acabado"),
    PATRIMONIO("Patrimônio"),
    INSUMO("Insumo"),
    COMSUMO("Consumo"),
    OUTROS("Outros");

    private final String descricao;

    TipoMovimentacaoItem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
