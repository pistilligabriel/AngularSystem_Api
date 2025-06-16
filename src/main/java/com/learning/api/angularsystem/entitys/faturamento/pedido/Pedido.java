package com.learning.api.angularsystem.entitys.faturamento.pedido;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.movimentacao.TipoFormaPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.NORMAL;

    @Column(name = "DATA_EMISSAO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEmissao;

    @JoinColumn(name = "INTEGRANTE")
    @ManyToOne
    private Cliente integrante;

    @Enumerated(EnumType.STRING)
    private TipoFormaPagamento formaPagamento;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<PedidoDetalhe> detalhes = new HashSet<>();

    @Column(name = "DESCONTO")
    private int desconto;

    @Column(name = "TOTAL")
    @Formula("(valorUnitario * quantidade)")
    private Double total;

    @Column(name = "PARCELAS")
    private int parcelas;

    @Column(name = "EMPRESA")
    private Long empresa = 1L;

    @Column(name = "VERSAO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime versao = LocalDateTime.now();


    public void setStatusNormal() {
        this.status = Status.NORMAL;
        this.versao = LocalDateTime.now();
    }

    public void setStatusCancelado() {
        this.status = Status.CANCELADO;
        this.versao = LocalDateTime.now();
    }

    public void setStatusFaturado(){
        this.status = Status.FATURADO;
        this.versao = LocalDateTime.now();
    }
}
