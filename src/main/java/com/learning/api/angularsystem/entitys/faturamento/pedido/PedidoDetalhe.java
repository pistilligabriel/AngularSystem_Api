package com.learning.api.angularsystem.entitys.faturamento.pedido;

import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.io.Serializable;

@Entity
@Table(name = "pedido_detalhe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDetalhe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @JoinColumn(name = "PEDIDO")
    @OneToOne
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "pedido_codigo")
    private Item item;

    @Column(name = "CANCELADO")
    private Boolean cancelado;

    @Column(name = "ORDEM")
    private Long ordem;

    @Column(name = "DESCRICAO")
    private String descricao;

    @JoinColumn(name = "UNIDADE_MEDIDA")
    @ManyToOne
    private UnidadeMedida unidadeMedida;

    @Column(name = "QUANTIDADE")
    private Double quantidade;

    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;

    @Column(name = "VALOR_DESCONTO")
    private Double valorDesconto;

    @Column(name = "VALOR_ACRESCIMO")
    private Double valorAcrescimo;

    @Column(name = "VALOR_TOTAL")
    @Formula("(valorUnitario * quantidade)")
    private Double valorTotal;


}
