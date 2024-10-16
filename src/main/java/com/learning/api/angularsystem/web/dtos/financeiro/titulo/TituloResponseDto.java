package com.learning.api.angularsystem.web.dtos.financeiro.titulo;

import com.learning.api.angularsystem.entitys.cadastro.integrante.IntegranteEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TituloResponseDto {

    private String statusTitulo;
    private String tipo;
    private String descricao;
    private String observacao;
    private IntegranteEntity integrante;
    private IntegranteEntity funcionario;
    private LocalDateTime dataLancamento;
    private LocalDateTime dataVencimento;
    private LocalDateTime dataUltimoPagamento;
    private Double valor;
    private Double valorDesconto;
    private Double valorAcrescimo;
    private Double valorPago;
    private Double valorEmAberto;
    private Double total;
}
