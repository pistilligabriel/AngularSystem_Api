package com.learning.api.angularsystem.entitys.cadastro.integrante;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.api.angularsystem.entitys.cadastro.usuario.UsuarioEntity;
import com.learning.api.angularsystem.entitys.faturamento.pedido.PedidoEntity;
import com.learning.api.angularsystem.enums.integrante.TipoDocumento;
import com.learning.api.angularsystem.web.dtos.cadastro.integrante.IntegranteDto;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.integrante.TipoIntegrante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "integrante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegranteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

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
    private Status status;

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
    private Set<PedidoEntity> pedidos;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "integrante", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<UsuarioEntity> usuario;

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
