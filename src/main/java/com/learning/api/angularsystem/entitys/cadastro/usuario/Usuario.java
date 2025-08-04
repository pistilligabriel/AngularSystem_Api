package com.learning.api.angularsystem.entitys.cadastro.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.usuario.Tipo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "DATA_CADASTRO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private Tipo tipo = Tipo.USUARIO;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name="DOCUMENTO")
    private String documento;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LOGIN", unique = true)
    private String login;

    @Column(name = "SENHA")
    private String password;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @Column(name = "EMPRESA")
    private Long empresa = 1L;

    @Column(name="TOKEN")
    private String token;

    @Column(name = "VERSAO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime versao = LocalDateTime.now();

    public void setStatusAtivo() {
        this.status = Status.ATIVO;
        this.versao = LocalDateTime.now();
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
        this.versao = LocalDateTime.now();
    }



//    Metodos do UserDetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

