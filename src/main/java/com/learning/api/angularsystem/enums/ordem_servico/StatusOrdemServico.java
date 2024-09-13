package com.learning.api.angularsystem.enums.ordem_servico;

public enum StatusOrdemServico {

    ORCAMENTO("Orçamento"),
    PRODUCAO("Produção"),
    FINALIZADO("Finalizado"),
    CONCLUIDO("Concluído"),
    FATURADO("Faturado");

    private final String descricao;

    StatusOrdemServico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
