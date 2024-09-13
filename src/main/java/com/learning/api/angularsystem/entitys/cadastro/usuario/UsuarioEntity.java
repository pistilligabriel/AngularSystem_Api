package com.learning.api.angularsystem.entitys.cadastro.usuario;

import com.learning.api.angularsystem.dtos.cadastro.usuario.UsuarioDto;
import com.learning.api.angularsystem.dtos.cadastro.usuario.table.UsuarioTableDto;
import com.learning.api.angularsystem.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name="NOME")
    private String nome;

    @Column(name="SOBRENOME")
    private String sobrenome;

    @Column(name="TELEFONE")
    private String telefone;

    @Column(name="EMAIL")
    private String email;

    @Column(name="DOCUMENTO")
    private String documento;

    @Column(name = "LOGIN", unique = true)
    private String login;

    @Column(name = "SENHA")
    private String password;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;

    public UsuarioEntity(UsuarioDto dadosUsuario) {
        this.nome = dadosUsuario.nome();
        this.sobrenome = dadosUsuario.sobrenome();
        this.telefone = dadosUsuario.telefone();
        this.email = dadosUsuario.email();
        this.documento = dadosUsuario.documento();
        this.login = dadosUsuario.login();
        this.password = new BCryptPasswordEncoder().encode(dadosUsuario.password());
        this.empresa = Long.valueOf(1);
        this.status = Status.ATIVO;
        this.versao = LocalDateTime.now();
    }

    public UsuarioEntity(UsuarioTableDto usuarioTableDto) {
        this.CODIGO = usuarioTableDto.CODIGO();
        this.login = usuarioTableDto.login();
        this.empresa = Long.valueOf(1);
        this.status = usuarioTableDto.status();
    }

    public void atualizarUsuario(UsuarioDto dadosUsuario) {
        if (dadosUsuario.nome() != null) {
            this.nome = dadosUsuario.nome();
        }   
        if (dadosUsuario.sobrenome() != null) {
            this.sobrenome = dadosUsuario.sobrenome();
        }
        if (dadosUsuario.telefone() != null) {
            this.telefone = dadosUsuario.telefone();
        }
        if (dadosUsuario.email() != null) {
            this.email = dadosUsuario.email();
        }
        if (dadosUsuario.documento() != null) {
            this.documento = dadosUsuario.documento();
        }
        if (dadosUsuario.login() != null) {
            this.login = dadosUsuario.login();
        }
        if (dadosUsuario.password() != null) {
            this.password = new BCryptPasswordEncoder().encode(dadosUsuario.password());
        }
        if (dadosUsuario.status() != null) {
            this.status = dadosUsuario.status();
        }
        this.empresa = Long.valueOf(1);
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

