package com.learning.api.angularsystem.entitys.faturamento.estoque;

import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedida;
import com.learning.api.angularsystem.entitys.faturamento.pedido.PedidoDetalhe;
import com.learning.api.angularsystem.enums.estoque.TipoEstoque;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "estoque")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estoque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoEstoque tipo;

    @Column(name = "DATA_OPERACAO")
    private LocalDateTime dataOperacao;

    @JoinColumn(name = "ITEM")
    @ManyToOne
    private Item item;

    @JoinColumn(name = "UNDIADE_MEDIDA")
    @ManyToOne
    private UnidadeMedida unidadeMedida;

    @Column(name = "QUANTIDADE")
    private Double quantidade;

    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @JoinColumn(name = "FUNCIONARIO")
    @ManyToOne
    private Cliente funcionario;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @JoinColumn(name = "PEDIDO_DETALHE")
    @ManyToOne
    private PedidoDetalhe pedidoDetalhe;

    @Column(name = "EMPRESA")
    private Long empresa = 1L;

    @Column(name = "VERSAO")
    private LocalDateTime versao = LocalDateTime.now();


}
