package com.learning.api.angularsystem.web.dtos.faturamento.pedido;

import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
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
    private int integrante;
    private Double total;
    private List<ItemDto> itens;

}
