package com.learning.api.angularsystem.web.dtos.faturamento.pedido;

import com.learning.api.angularsystem.enums.movimentacao.TipoFormaPagamento;
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
    private LocalDateTime dataEmissao = LocalDateTime.now();
    private Long integrante;
    private int desconto;
    private TipoFormaPagamento formaPagamento;
    private int parcelas;
    private Double total;
    private List<ItemDto> produtos;

}
