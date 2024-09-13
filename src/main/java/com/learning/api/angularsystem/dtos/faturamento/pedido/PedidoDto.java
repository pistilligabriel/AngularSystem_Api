package com.learning.api.angularsystem.dtos.faturamento.pedido;

import com.learning.api.angularsystem.dtos.cadastro.integrante.NewIntegranteDto;
import com.learning.api.angularsystem.entitys.faturamento.pedido.PedidoEntity;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.pedido.FinalidadePedido;
import com.learning.api.angularsystem.enums.pedido.StatusPedido;
import com.learning.api.angularsystem.enums.pedido.TipoMovimentacaoPedido;
import com.learning.api.angularsystem.enums.pedido.TipoPedido;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PedidoDto(

        Long CODIGO,
        @Enumerated
        TipoPedido tipo,
        @Enumerated
        TipoMovimentacaoPedido tipoMovimentacao,
        @Enumerated
        FinalidadePedido finalidade,
        @Enumerated
        StatusPedido statusPedido,
        Long numero,
        String controle,
        LocalDateTime dataEmissao,
        LocalDateTime dataEntrega,
        LocalDateTime dataFatura,
        LocalDateTime dataValidade,
        LocalDateTime dataPrevisao,
        NewIntegranteDto integrante,
        Double totalProduto,
        Double totalDesconto,
        Double totalAcrescimo,
        Double total,
        @Enumerated
        Status status,
        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,
        LocalDateTime versao
) {
    public PedidoDto(PedidoEntity pedidoEntity) {
        this(pedidoEntity.getCODIGO(),
                pedidoEntity.getTipo(),
                pedidoEntity.getTipoMovimentacao(),
                pedidoEntity.getFinalidade(),
                pedidoEntity.getStatusPedido(),
                pedidoEntity.getNumero(),
                pedidoEntity.getControle(),
                pedidoEntity.getDataEmissao(),
                pedidoEntity.getDataEntrega(),
                pedidoEntity.getDataFatura(),
                pedidoEntity.getDataValidade(),
                pedidoEntity.getDataPrevisao(),
                pedidoEntity.getIntegrante() != null ?
                        new NewIntegranteDto(pedidoEntity.getIntegrante().getCODIGO()) : null,
                pedidoEntity.getTotalProduto(),
                pedidoEntity.getTotalDesconto(),
                pedidoEntity.getTotalAcrescimo(),
                pedidoEntity.getTotal(),
                pedidoEntity.getStatus(),
                pedidoEntity.getEmpresa(),
                pedidoEntity.getVersao());
    }
}
