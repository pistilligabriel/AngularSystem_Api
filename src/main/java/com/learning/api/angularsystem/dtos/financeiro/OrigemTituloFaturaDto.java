package com.learning.api.angularsystem.dtos.financeiro;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrigemTituloFaturaDto {

    private Long codigo;
    private LocalDateTime dataCriacao;
    private Object pedido;
    private Object titulo;

}
