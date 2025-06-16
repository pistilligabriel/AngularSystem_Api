package com.learning.api.angularsystem.web.dtos.faturamento.pedido;

import lombok.Getter;

@Getter
public class DetalheResponseDto {
    private int posicao;
    private String descricao;
    private int unidadeMedida;
    private int fabricante;
    private String modelo;
    private int quantidade;
    private Double valor;
    private Double total;
}
