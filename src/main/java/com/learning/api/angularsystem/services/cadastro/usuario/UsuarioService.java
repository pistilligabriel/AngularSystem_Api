package com.learning.api.angularsystem.services.cadastro.usuario;

import com.learning.api.angularsystem.entitys.cadastro.usuario.Usuario;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.infra.security.TokenService;
import com.learning.api.angularsystem.repositories.cadastro.usuario.UsuarioRepository;
import com.learning.api.angularsystem.web.dtos.cadastro.usuario.AuthenticationDto;
import com.learning.api.angularsystem.web.dtos.cadastro.usuario.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    @Transactional
    public Usuario createUsuario(UsuarioDto dto){
        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setSobrenome(dto.getSobrenome());
        usuario.setEmail(dto.getEmail());
        usuario.setDocumento(dto.getDocumento());
        usuario.setTelefone(dto.getTelefone());
        usuario.setLogin(dto.getLogin());
        usuario.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
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

    @Transactional
    public Usuario atualizarUsuario(Usuario usuario){
        Usuario usuarioAtualizar = getById(usuario.getCodigo());

        if(!usuarioAtualizar.getStatus().equals(Status.ATIVO)){
            throw new RuntimeException("Usuário não pode ser alterado, pois está desativado!");
        }

        usuarioAtualizar.setNome(usuario.getNome());
        usuarioAtualizar.setSobrenome(usuario.getSobrenome());
        usuarioAtualizar.setTelefone(usuario.getTelefone());
        usuarioAtualizar.setDocumento(usuario.getDocumento());
        usuarioAtualizar.setEmail(usuario.getEmail());
        usuarioAtualizar.setLogin(usuario.getLogin());
        usuarioAtualizar.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        usuarioAtualizar.setVersao(LocalDateTime.now());
        return repository.save(usuarioAtualizar);
    }
}
