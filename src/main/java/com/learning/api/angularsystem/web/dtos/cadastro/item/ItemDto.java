package com.learning.api.angularsystem.web.dtos.cadastro.item;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemDto {

    private int grupoItem;

    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;

    private String observacao;

    private String unidadeVenda;

    private String fabricante;

    private Double precoCusto;

    private Double precoVenda;

    private Double estoque;

    private Double margemLucro;


}
