package com.learning.api.angularsystem.web.controllers.cadastro.usuario;

import com.learning.api.angularsystem.entitys.cadastro.usuario.Usuario;
import com.learning.api.angularsystem.services.cadastro.usuario.UsuarioService;
import com.learning.api.angularsystem.web.dtos.cadastro.usuario.AuthenticationDto;
import com.learning.api.angularsystem.infra.security.TokenService;
import com.learning.api.angularsystem.web.dtos.cadastro.usuario.LoginResponseDto;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/autenticar")
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto authenticationDto)  {
       logger.info("Iniciando autenticação para o login: {}", authenticationDto.getLogin());
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDto.getLogin(), authenticationDto.getPassword());
        var authentication = authenticationManager.authenticate(usernamePassword);

        logger.info("Autenticação bem-sucedida para o login: {}", authenticationDto.getLogin());
        var usuario = (Usuario) authentication.getPrincipal();

        logger.debug("Usuário autenticado: {}", usuario.getLogin());
        var token = tokenService.generateToken(usuario);

        usuarioService.salvarToken(usuario.getCodigo(), token);
        
        logger.info("Token gerado com sucesso para o login: {}", authenticationDto.getLogin());
        return ResponseEntity.ok(new LoginResponseDto(token, usuario));
    }

   

}
