package com.learning.api.angularsystem.entitys.faturamento.pedido;

import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.io.Serializable;

@Entity
@Table(name = "pedido_detalhe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PedidoDetalhe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "PEDIDO")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "ITEM")
    private Item item;

    @Column(name = "ORDEM")
    private int ordem;

    @Column(name = "DESCRICAO")
    private String descricao;


    @Column(name = "QUANTIDADE")
    private int quantidade;

    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;

    @Column(name = "VALOR_TOTAL")
    @Formula("(valorUnitario * quantidade)")
    private Double valorTotal;


}
