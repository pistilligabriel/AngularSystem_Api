package com.learning.api.angularsystem.entitys.cadastro.item;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.api.angularsystem.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "DATA_CADASTRO")
    private LocalDateTime dataCadastro;

    @Column(name="MODELO")
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "GRUPO_ITEM")
    private ItemGrupo grupoItem;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "UNIDADE_VENDA")
    @JsonIgnore
    private UnidadeMedida unidadeVenda;

    @ManyToOne
    @JoinColumn(name = "FABRICANTE")
    @JsonIgnore
    private Fabricante fabricante;

    @Column(name = "PRECO_CUSTO")
    private Double precoCusto;

    @Column(name = "PRECO_VENDA")
    private Double precoVenda;

    @Column(name = "MARGEM_LUCRO")
    private Double margemLucro;

    @Column(name = "ESTOQUE")
    private Double estoque;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @Column(name = "EMPRESA")
    private Long empresa = 1L;

    @Column(name = "VERSAO")
    private LocalDateTime versao = LocalDateTime.now();


    public void setStatusAtivo() {
        this.status = Status.ATIVO;
        this.versao = LocalDateTime.now();
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
        this.versao = LocalDateTime.now();
    }

    public Double calcularMargemLucro(){
        precoCusto = getPrecoCusto();
        precoVenda = getPrecoVenda();
        return ((precoVenda - precoCusto) / precoCusto) * 100;
    }

}
