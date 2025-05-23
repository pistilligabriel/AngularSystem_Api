package com.learning.api.angularsystem.web.dtos.cadastro.item;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FabricanteDto {
    private Long codigo;
    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;



}
