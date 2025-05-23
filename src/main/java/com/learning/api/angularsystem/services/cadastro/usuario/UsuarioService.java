package com.learning.api.angularsystem.services.cadastro.usuario;

import com.learning.api.angularsystem.entitys.cadastro.usuario.Usuario;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.infra.security.TokenService;
import com.learning.api.angularsystem.repositories.cadastro.usuario.UsuarioRepository;
import com.learning.api.angularsystem.web.dtos.cadastro.usuario.AuthenticationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    @Transactional
    public Usuario createUsuario(Usuario usuario){
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        return repository.save(usuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> getAllUsuarios(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario getById(Long codigo){
        return repository.findById(codigo).orElseThrow(
                () -> new RuntimeException("Usuario não encontrada")
        );
    }

    @Transactional()
    public Usuario alterarStatus(Long codigo){
        Usuario usuario = getById(codigo);
        if(usuario.getStatus().equals(Status.ATIVO)){
            usuario.setStatusInativo();
        } else {
            usuario.setStatusAtivo();
        }
        return usuario;
    }

    @Transactional()
    public Usuario deletarUsuario(Long codigo){
        Usuario usuario = getById(codigo);
        if(usuario.getStatus().equals(Status.DESATIVADO)){
            repository.deleteById(usuario.getCodigo());
        } else{
            throw new RuntimeException("Usuario não pode ser deletado!");
        }
        return usuario;
    }
}
