package com.learning.api.angularsystem.dtos.faturamento.pedido;

import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.pedido.FinalidadePedido;
import com.learning.api.angularsystem.enums.pedido.StatusPedido;
import com.learning.api.angularsystem.enums.pedido.TipoMovimentacaoPedido;
import com.learning.api.angularsystem.enums.pedido.TipoPedido;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidoDto {
    private Long codigo;

    private String tipo;

    private String tipoMovimentacao;

    private String finalidade;

    private String statusPedido;
    private Long numero;
    private String controle;
    private LocalDateTime dataEmissao;
    private LocalDateTime dataEntrega;
    private LocalDateTime dataFatura;
    private LocalDateTime dataValidade;
    private LocalDateTime dataPrevisao;
    private Object integrante;
    private Double totalProduto;
    private Double totalDesconto;
    private Double totalAcrescimo;
    private Double total;

    private String status;
    @NotNull(message = "O campo empresa é obrigatório")
    private Long empresa;
    private LocalDateTime versao;

}
