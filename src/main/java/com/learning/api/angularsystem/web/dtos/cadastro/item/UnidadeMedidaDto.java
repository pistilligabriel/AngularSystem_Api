package com.learning.api.angularsystem.web.dtos.cadastro.item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UnidadeMedidaDto {

    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;

    @NotBlank(message = "O campo simbolo é obrigatório")
    private String simbolo;
}
