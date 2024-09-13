package com.learning.api.angularsystem.dtos.faturamento.pedido;

public class NewPedidoDetalheDto {

    private final Long CODIGO;

    public NewPedidoDetalheDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
