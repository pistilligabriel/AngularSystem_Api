package com.learning.api.angularsystem.web.dtos.financeiro.titulo;

import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TituloDto {

    private String statusTitulo;
    private String tipo;
    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;
    private String observacao;
    private Cliente integrante;
    private Cliente funcionario;
    private LocalDateTime dataLancamento;
    private LocalDateTime dataVencimento;
    private LocalDateTime dataUltimoPagamento;
    private Double valor;
    private Double valorDesconto;
    private Double valorAcrescimo;
    private Double valorPago;
    private Double valorEmAberto;
    private Double total;

}
