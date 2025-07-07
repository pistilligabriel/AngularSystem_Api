package com.learning.api.angularsystem.web.controllers.cadastro.usuario;


import com.learning.api.angularsystem.entitys.cadastro.usuario.Usuario;
import com.learning.api.angularsystem.web.dtos.cadastro.usuario.UsuarioDto;
import com.learning.api.angularsystem.services.cadastro.usuario.UsuarioService;
import com.learning.api.angularsystem.web.dtos.cadastro.usuario.UsuarioResponseDto;
import com.learning.api.angularsystem.web.dtos.cadastro.usuario.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        Usuario usuario = service.createUsuario(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listarUsuarios() {
        List<Usuario> usuarios = service.getAllUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toListDto(usuarios));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<UsuarioResponseDto> buscarUsuario(@PathVariable Long codigo) {
        Usuario usuario = service.getById(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toDto(usuario));
    }

    @PutMapping
    public ResponseEntity<UsuarioResponseDto> atualizarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        Usuario usuario = service.atualizarUsuario(UsuarioMapper.toUsuario(usuarioDto));
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toDto(usuario));
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity<UsuarioResponseDto> deletarUsuario(@PathVariable Long codigo) {
        service.deletarUsuario(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/alterar-status/{codigo}")
    public ResponseEntity<UsuarioResponseDto> alterarStatusUsuario(@PathVariable Long codigo) {
        service.alterarStatus(codigo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/perfil")
    public ResponseEntity<Usuario> getUsuarioPerfil() {
        // Recuperando a autenticação
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Verificando se a autenticação está presente e se o principal é do tipo UserDetails
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            // Realizando o cast seguro para UserDetails
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // Acessando o nome de usuário (login)
            String login = userDetails.getUsername();

            // Agora, você pode usar o login para buscar o usuário no banco de dados
            Usuario usuario = service.buscarPorLogin(login);

            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } else {
            // Caso a autenticação não seja válida ou o principal não seja um UserDetails
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
