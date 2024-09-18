package com.learning.api.angularsystem.dtos.faturamento.pedido;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidoDetalheDto {

    private Long CODIGO;
    private Object pedido;
    private Object item;
    private Boolean cancelado;
    private Long ordem;
    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;
    private String unidadeMedida;
    private Double quantidade;
    private Double quantidadeDevolvida;
    private Double quantidadeFaturada;
    private Double quantidadeEntregue;
    private Double valorUnitario;
    private Double valorDesconto;
    private Double valorAcrescimo;
    private Double valorTotal;
}

