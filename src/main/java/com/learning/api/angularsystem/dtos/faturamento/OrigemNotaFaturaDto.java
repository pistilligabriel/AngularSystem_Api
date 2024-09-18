package com.learning.api.angularsystem.dtos.faturamento;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrigemNotaFaturaDto {

    private Long CODIGO;
    private LocalDateTime dataCriacao;
    private Object pedidoDetalhe;


}
