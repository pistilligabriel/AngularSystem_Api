package com.learning.api.angularsystem.dtos.financeiro.movimentacao;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class MovimentacaoDto {

    private Long CODIGO;
    private String statusMovimentacao;
    private String tipo;
    private String tipoMovimentacao;
    private Object titulo;
    private String descricao;
    private String observacao;
    private Object integrante;
    private Object funcionario;
    private Object formaPagamento;
    private LocalDateTime dataLancamento;
    private LocalDateTime dataVencimento;
    private LocalDateTime dataCompensacao;
    private Double valor;
    private Double valorDesconto;
    private Double valorAcrescimo;
    private Double total;
    private String status;
    @NotNull(message = "O campo empresa é obrigatório")
    private Long empresa;
    private LocalDateTime versao;

}
