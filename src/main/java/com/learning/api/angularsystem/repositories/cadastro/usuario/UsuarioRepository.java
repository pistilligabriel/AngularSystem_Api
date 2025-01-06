package com.learning.api.angularsystem.repositories.cadastro.usuario;

import com.learning.api.angularsystem.entitys.cadastro.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
