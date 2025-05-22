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
    private int pedido;
    private int item;
    private boolean cancelado;
    private int ordem;
    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;
    private int unidadeMedida;
    private Double quantidade;
    private Double valorUnitario;
    private Double valorDesconto;
    private Double valorAcrescimo;
    private Double valorTotal;
}

