package com.learning.api.angularsystem.web.dtos.cadastro.item;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UnidadeMedidaResponseDto {
    private Long codigo;
    private String descricao;
    private String simbolo;
    private String status;
}
