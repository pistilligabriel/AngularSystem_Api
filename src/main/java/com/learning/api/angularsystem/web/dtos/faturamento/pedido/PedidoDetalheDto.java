package com.learning.api.angularsystem.web.dtos.faturamento.pedido;

import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedida;
import com.learning.api.angularsystem.entitys.faturamento.pedido.Pedido;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidoDetalheDto {
    private Pedido pedido;
    private Item item;
    private Boolean cancelado;
    private Long ordem;
    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;
    private UnidadeMedida unidadeMedida;
    private Double quantidade;
    private Double valorUnitario;
    private Double valorDesconto;
    private Double valorAcrescimo;
    private Double valorTotal;
}

