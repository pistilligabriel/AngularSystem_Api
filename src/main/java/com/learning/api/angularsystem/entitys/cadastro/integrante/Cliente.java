package com.learning.api.angularsystem.entitys.cadastro.integrante;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.api.angularsystem.entitys.faturamento.pedido.Pedido;
import com.learning.api.angularsystem.enums.integrante.TipoDocumento;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.integrante.TipoIntegrante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoIntegrante tipoIntegrante = TipoIntegrante.CLIENTE;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SEGUNDO_NOME")
    private String sobrenome;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TIPO_DOCUMENTO")
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(name = "DOCUMENTO", unique = true)
    private String documento;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "MUNICIPIO")
    private String municipio;

    @Column(name = "UF")
    private String uf;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "integrante", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Pedido> pedidos;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "EMPRESA")
    private Long empresa = 1L;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public void setStatusAtivo() {
        this.status = Status.ATIVO;
        this.versao = LocalDateTime.now();
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
        this.versao = LocalDateTime.now();
    }
}
