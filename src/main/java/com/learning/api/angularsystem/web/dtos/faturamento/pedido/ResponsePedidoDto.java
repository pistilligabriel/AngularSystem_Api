package com.learning.api.angularsystem.web.dtos.faturamento.pedido;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponsePedidoDto {
   private Long codigo;
   private PedidoDto pedidoDto;
}
