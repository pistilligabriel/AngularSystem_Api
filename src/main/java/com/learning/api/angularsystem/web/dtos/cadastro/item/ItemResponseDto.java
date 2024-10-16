package com.learning.api.angularsystem.web.dtos.cadastro.item;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemResponseDto {
    private Long codigo;
    private String grupoItem;
    private String descricao;
    private String observacao;
    private String unidadeVenda;
    private String fabricante;
    private Double precoVenda;
    private Double estoque;
}
