package com.learning.api.angularsystem.web.dtos.faturamento.pedido;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.movimentacao.TipoFormaPagamento;
import com.learning.api.angularsystem.enums.pedido.TipoPedido;
import com.learning.api.angularsystem.web.dtos.cadastro.integrante.ClienteDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidoDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEmissao = LocalDateTime.now();
    private Status status;
    private ClienteDto integrante;
    private TipoPedido tipoVenda;
    private Double porcentagemDesconto;
    private Double desconto;
    private TipoFormaPagamento formaPagamento;
    private int parcelas;
    private Double total;
    private Double lucro;
    private Double custo;
    private Double totalSemDesconto;
    private List<ItemDto> produtos;

}
