package com.learning.api.angularsystem.dtos.faturamento.pedido;

public class NewPedidoDto {

    private final Long CODIGO;

    public NewPedidoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
