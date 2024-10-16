package com.learning.api.angularsystem.web.dtos.faturamento.pedido;

import com.learning.api.angularsystem.entitys.cadastro.item.ItemEntity;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedidaEntity;
import com.learning.api.angularsystem.entitys.faturamento.pedido.PedidoEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidoDetalheDto {
    private PedidoEntity pedido;
    private ItemEntity item;
    private Boolean cancelado;
    private Long ordem;
    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;
    private UnidadeMedidaEntity unidadeMedida;
    private Double quantidade;
    private Double valorUnitario;
    private Double valorDesconto;
    private Double valorAcrescimo;
    private Double valorTotal;
}

