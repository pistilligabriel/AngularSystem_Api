package com.learning.api.angularsystem.web.dtos.financeiro.movimentacao;


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

    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;
    private String tipo;
}
