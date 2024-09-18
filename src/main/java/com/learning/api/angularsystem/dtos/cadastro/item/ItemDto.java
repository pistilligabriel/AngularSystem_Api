package com.learning.api.angularsystem.dtos.cadastro.item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemDto {

    private Long codigo;

    private LocalDateTime dataCadastro;

    private String grupoItem;

    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;

    private String observacao;

    private String unidadeVenda;

    private String fabricante;

    private String codigoBarras;

    private String codigoOriginal;

    private Double precoCusto;

    private Double precoVenda;

    private Double estoque;

    private Double margemLucro;


    private String status;

    @NotNull(message = "O campo empresa é obrigatório")
    private Long empresa;

    private LocalDateTime versao;

}
