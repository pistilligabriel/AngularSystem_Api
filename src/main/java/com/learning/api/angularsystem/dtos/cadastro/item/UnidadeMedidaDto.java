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
public class UnidadeMedidaDto {

    private Long codigo;

    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;

    @NotBlank(message = "O campo simbolo é obrigatório")
    private String simbolo;

    private String status;

    @NotNull(message = "O campo empresa é obrigatório")
    private Long empresa;

    private LocalDateTime versao;

}
