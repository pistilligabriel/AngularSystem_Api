package com.learning.api.angularsystem.dtos.financeiro.titulo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TituloDto {

    private Long codigo;
    private String statusTitulo;
    private String tipo;
    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;
    private String observacao;
    private Object integrante;
    private Object funcionario;
    private LocalDateTime dataLancamento;
    private LocalDateTime dataVencimento;
    private LocalDateTime dataUltimoPagamento;
    private Double valor;
    private Double valorDesconto;
    private Double valorAcrescimo;
    private Double valorJuros;
    private Double valorMulta;
    private Double valorPago;
    private Double valorEmAberto;
    private Double total;
    private String status;
    @NotNull(message = "O campo empresa é obrigatório")
    private Long empresa;
    private LocalDateTime versao;
}
