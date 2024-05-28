package com.learning.api.minisys.entitys.cadastro.integrante;

import com.learning.api.minisys.dtos.cadastro.integrante.IntegranteDto;
import com.learning.api.minisys.dtos.cadastro.integrante.NewIntegranteDto;
import com.learning.api.minisys.dtos.cadastro.integrante.table.IntegranteTableDto;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.integrante.TipoDocumento;
import com.learning.api.minisys.enums.integrante.TipoIntegrante;
import com.learning.api.minisys.enums.integrante.TipoLogradouro;
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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "integrante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    TipoIntegrante tipoIntegrante;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SEGUNDO_NOME")
    private String segundoNome;

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

    @Column(name = "TIPO_LOGRADOURO")
    private TipoLogradouro tipoLogradouro;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private int numero;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "MUNICIPIO")
    private String municipio;

    @Column(name = "UF")
    private String uf;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public IntegranteEntity(IntegranteDto dadosIntegrante) {
        this.tipoIntegrante = TipoIntegrante.CLIENTE;
        this.nome = dadosIntegrante.nome();
        this.segundoNome = dadosIntegrante.segundoNome();
        this.telefone = dadosIntegrante.telefone();
        this.email = dadosIntegrante.email();
        this.tipoDocumento = dadosIntegrante.tipoDocumento();
        this.documento = dadosIntegrante.documento();
        this.dataCriacao = LocalDateTime.now();
        this.status = Status.ATIVO;
        this.cep = dadosIntegrante.cep();
        this.tipoLogradouro = dadosIntegrante.tipoLogradouro();
        this.logradouro = dadosIntegrante.logradouro();
        this.numero = dadosIntegrante.numero();
        this.bairro = dadosIntegrante.bairro();
        this.municipio = dadosIntegrante.municipio();
        this.uf = dadosIntegrante.uf();
        this.complemento = dadosIntegrante.complemento();
        this.empresa = Long.valueOf(1);
        this.versao = LocalDateTime.now();
    }

    public IntegranteEntity(NewIntegranteDto integrante) {
    }

    public IntegranteEntity(IntegranteTableDto integranteTableDto) {
        this.CODIGO = integranteTableDto.CODIGO();
        this.nome = integranteTableDto.nome();
    }

    public void atualizarIntegrante(IntegranteDto dadosIntegrante) {

        if (dadosIntegrante.nome() != null) {
            this.nome = dadosIntegrante.nome();
        }
        if (dadosIntegrante.segundoNome() != null) {
            this.segundoNome = dadosIntegrante.segundoNome();
        }
        if (dadosIntegrante.telefone() != null) {
            this.telefone = dadosIntegrante.telefone();
        }
        if (dadosIntegrante.email() != null) {
            this.email = dadosIntegrante.email();
        }
        if (dadosIntegrante.tipoDocumento() != null) {
            this.tipoDocumento = dadosIntegrante.tipoDocumento();
        }
        if (dadosIntegrante.documento() != null) {
            this.documento = dadosIntegrante.documento();
        }
        if (dadosIntegrante.status() != null) {
            this.status = dadosIntegrante.status();
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
}
