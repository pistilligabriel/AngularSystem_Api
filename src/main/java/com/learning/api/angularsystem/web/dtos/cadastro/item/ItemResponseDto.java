package com.learning.api.angularsystem.web.dtos.cadastro.item;

import com.learning.api.angularsystem.entitys.cadastro.item.Fabricante;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedida;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemResponseDto {
    private Long codigo;
    private String status;
    private String grupoItem;
    private String descricao;
    private String observacao;
    private String modelo;
    private UnidadeMedida unidadeVenda;
    private Fabricante fabricante;
    private Double precoVenda;
    private Double estoque;
}
