package com.learning.api.angularsystem.web.dtos.faturamento.pedido;

import com.learning.api.angularsystem.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.angularsystem.entitys.cadastro.item.ItemEntity;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.pedido.FinalidadePedido;
import com.learning.api.angularsystem.enums.pedido.StatusPedido;
import com.learning.api.angularsystem.enums.pedido.TipoMovimentacaoPedido;
import com.learning.api.angularsystem.enums.pedido.TipoPedido;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidoDto {
    private String tipo;
    private String tipoMovimentacao;
    private String finalidade;
    private String statusPedido;
    private Long numero;
    private LocalDateTime dataEmissao;
    private LocalDateTime dataValidade;
    private IntegranteEntity integrante;
    private Double totalProduto;
    private Double totalDesconto;
    private Double totalAcrescimo;
    private Double total;
    private Set<ItemEntity> itens;

}
