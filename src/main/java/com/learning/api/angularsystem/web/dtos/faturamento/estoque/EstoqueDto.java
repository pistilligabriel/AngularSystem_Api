package com.learning.api.angularsystem.web.dtos.faturamento.estoque;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EstoqueDto {

    private String tipo;
    private LocalDateTime dataOperacao;
    private boolean reservado;
    private int item;
    private int unidadeMedida;
    private int quantidade;
    private Double valorUnitario;
    private Double valorTotal;
    private String lote;
    private String numeroSerie;
    private LocalDateTime dataValidade;
    private LocalDateTime dataFabricacao;
    private int funcionario;
    private String observacao;
    private String motivoAcerto;
}
