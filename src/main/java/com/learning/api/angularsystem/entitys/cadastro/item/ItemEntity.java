package com.learning.api.angularsystem.entitys.cadastro.item;

import com.learning.api.angularsystem.dtos.cadastro.item.NewItemDto;
import com.learning.api.angularsystem.dtos.cadastro.item.ItemDto;
import com.learning.api.angularsystem.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "DATA_CADASTRO")
    private LocalDateTime dataCadastro;

    @JoinColumn(name = "GRUPO_ITEM")
    @ManyToOne
    private ItemGrupoEntity grupoItem;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @JoinColumn(name = "UNIDADE_VENDA")
    @ManyToOne
    private UnidadeMedidaEntity unidadeVenda;

    //@JoinColumn(name = "FABRICANTE")
    //@ManyToOne
    @Column(name = "FABRICANTE")
    String fabricante;
    //private FabricanteEntity fabricante;

    @Column(name = "CODIGO_BARRAS", unique = true)
    private String codigoBarras;

    @Column(name = "CODIGO_ORIGINAL", unique = true)
    private String codigoOriginal;

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
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public ItemEntity(ItemDto dadosItem) {
        this.dataCadastro = LocalDateTime.now();
        this.grupoItem = dadosItem.grupoItem() != null ?
                new ItemGrupoEntity(dadosItem.grupoItem()) : null;
        this.descricao = dadosItem.descricao();
        this.observacao = dadosItem.observacao();
        this.unidadeVenda = dadosItem.unidadeVenda() != null ?
                new UnidadeMedidaEntity(dadosItem.unidadeVenda()) : null;
        //this.fabricante = dadosItem.fabricante() != null ? new FabricanteEntity(dadosItem.fabricante()) : null;
        this.fabricante = dadosItem.fabricante();
        this.codigoBarras = dadosItem.codigoBarras();
        this.codigoOriginal = dadosItem.codigoOriginal();
        this.precoCusto = dadosItem.precoCusto();
        this.precoVenda = dadosItem.precoVenda();
        this.margemLucro = calcularMargemLucro();
        this.empresa = dadosItem.empresa();
        this.status = Status.ATIVO;
        this.versao = LocalDateTime.now();
    }

    public ItemEntity(NewItemDto item) {}

    public void atualizarItem(ItemDto dadosItem) {
        if (dadosItem.grupoItem() != null) {
            this.grupoItem = new ItemGrupoEntity(dadosItem.grupoItem());
        }
        if (dadosItem.descricao() != null) {
            this.descricao = dadosItem.descricao();
        }
        if (dadosItem.observacao() != null) {
            this.observacao = dadosItem.observacao();
        }
        if (dadosItem.unidadeVenda() != null) {
            this.unidadeVenda = new UnidadeMedidaEntity(dadosItem.unidadeVenda());
        }
        //if (dadosItem.fabricante() != null) {this.fabricante = new FabricanteEntity(dadosItem.fabricante());}
        if (dadosItem.fabricante() != null){
            this.fabricante = dadosItem.fabricante();
        }
        if (dadosItem.codigoBarras() != null) {
            this.codigoBarras = dadosItem.codigoBarras();
        }
        if (dadosItem.codigoOriginal() != null) {
            this.codigoOriginal = dadosItem.codigoOriginal();
        }
        if (dadosItem.precoCusto() != null) {
            this.precoCusto = dadosItem.precoCusto();
        }
        if (dadosItem.precoVenda() != null) {
            this.precoVenda = dadosItem.precoVenda();
        }
        if (dadosItem.status() != null) {
            this.status = dadosItem.status();
        }
        if (dadosItem.empresa() != null) {
            this.empresa = dadosItem.empresa();
        }
        this.versao = LocalDateTime.now();
    }

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
