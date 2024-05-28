package com.learning.api.minisys.entitys.cadastro.usuario;

import com.learning.api.minisys.dtos.cadastro.usuario.UsuarioDto;
import com.learning.api.minisys.dtos.cadastro.usuario.table.UsuarioTableDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

    @JoinColumn(name = "funcionario")
    @ManyToOne
    private IntegranteEntity funcionario;

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

