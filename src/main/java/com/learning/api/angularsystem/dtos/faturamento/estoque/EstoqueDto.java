package com.learning.api.angularsystem.dtos.faturamento.estoque;

import com.learning.api.angularsystem.dtos.cadastro.integrante.NewIntegranteDto;
import com.learning.api.angularsystem.dtos.cadastro.item.NewItemDto;
import com.learning.api.angularsystem.dtos.cadastro.item.NewUnidadeMedidaDto;
import com.learning.api.angularsystem.dtos.faturamento.nota_fiscal.NewNotaFiscalDetalheDto;
import com.learning.api.angularsystem.dtos.faturamento.ordem_servico.NewOrdemServicoDetalheDto;
import com.learning.api.angularsystem.dtos.faturamento.pedido.NewPedidoDetalheDto;
import com.learning.api.angularsystem.entitys.faturamento.estoque.EstoqueEntity;
import com.learning.api.angularsystem.enums.estoque.TipoEstoque;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EstoqueDto(

        Long CODIGO,
        @Enumerated
        TipoEstoque tipo,
        LocalDateTime dataOperacao,
        Boolean reservado,
        NewItemDto item,
        NewUnidadeMedidaDto unidadeMedida,
        Double quantidade,
        Double valorUnitario,
        Double valorTotal,
        String lote,
        String numeroSerie,
        LocalDateTime dataValidade,
        LocalDateTime dataFabricacao,
        NewIntegranteDto funcionario,
        String observacao,
        String motivoAcerto,
        NewPedidoDetalheDto pedidoDetalhe,
        NewOrdemServicoDetalheDto ordemServicoDetalhe,
        NewNotaFiscalDetalheDto notaFiscalDetalhe,
        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,
        LocalDateTime versao
) {
    public EstoqueDto(EstoqueEntity estoqueEntity) {
        this(estoqueEntity.getCODIGO(),
                estoqueEntity.getTipo(),
                estoqueEntity.getDataOperacao(),
                estoqueEntity.getReservado(),
                estoqueEntity.getItem() != null ?
                        new NewItemDto(estoqueEntity.getItem().getCODIGO()) : null,
                estoqueEntity.getUnidadeMedida() != null ?
                        new NewUnidadeMedidaDto(estoqueEntity.getUnidadeMedida().getCODIGO()) : null,
                estoqueEntity.getQuantidade(),
                estoqueEntity.getValorUnitario(),
                estoqueEntity.getValorTotal(),
                estoqueEntity.getLote(),
                estoqueEntity.getNumeroSerie(),
                estoqueEntity.getDataValidade(),
                estoqueEntity.getDataFabricacao(),
                estoqueEntity.getFuncionario() != null ?
                        new NewIntegranteDto(estoqueEntity.getFuncionario().getCODIGO()) : null,
                estoqueEntity.getObservacao(),
                estoqueEntity.getMotivoAcerto(),
                estoqueEntity.getPedidoDetalhe() != null ?
                        new NewPedidoDetalheDto(estoqueEntity.getPedidoDetalhe().getCODIGO()) : null,
                estoqueEntity.getOrdemServicoDetalhe() != null ?
                        new NewOrdemServicoDetalheDto(estoqueEntity.getOrdemServicoDetalhe().getCODIGO()) : null,
                estoqueEntity.getNotaFiscalDetalhe() != null ?
                        new NewNotaFiscalDetalheDto(estoqueEntity.getNotaFiscalDetalhe().getCODIGO()) : null,
                estoqueEntity.getEmpresa(),
                estoqueEntity.getVersao());
    }
}
