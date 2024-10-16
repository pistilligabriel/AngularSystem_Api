package com.learning.api.angularsystem.web.dtos.financeiro.movimentacao;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseFormaPagamentoDto {
    private Long codigo;
    private String descricao;
    private String tipo;
}
