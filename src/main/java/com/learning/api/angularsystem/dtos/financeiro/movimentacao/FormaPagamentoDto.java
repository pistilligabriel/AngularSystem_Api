package com.learning.api.angularsystem.dtos.financeiro.movimentacao;


import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FormaPagamentoDto{

    private Long CODIGO;
    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;
    @Enumerated
    private String tipo;
    @Enumerated
    private String status;
    @NotNull(message = "O campo empresa é obrigatório")
    private Long empresa;
    private LocalDateTime versao;
}
