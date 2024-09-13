package com.learning.api.angularsystem.enums.ordem_servico;

public enum FinalidadeOrdemServico {

    NORMAL("Normal"),
    BRINDE("Brinde"),
    AMOSTRA("Amostra"),
    GARANTIA("Garantia"),
    TROCA("Troca"),
    DEVOLUCAO("Devolução"),
    REPARO("Reparo"),
    REPOSICAO("Reposição"),
    CANCELAMENTO("Cancelamento"),
    OUTROS("Outros");

    private final String descricao;

    FinalidadeOrdemServico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
