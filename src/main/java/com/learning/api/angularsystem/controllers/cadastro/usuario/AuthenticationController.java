package com.learning.api.angularsystem.controllers.cadastro.usuario;

import com.learning.api.angularsystem.dtos.cadastro.usuario.AuthenticationDto;
import com.learning.api.angularsystem.dtos.cadastro.usuario.LoginResponseDto;
import com.learning.api.angularsystem.entitys.cadastro.usuario.UsuarioEntity;
import com.learning.api.angularsystem.infra.security.TokenService;
import com.learning.api.angularsystem.services.cadastro.usuario.UsuarioService;
import jakarta.validation.Valid;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto authenticationDto)  {
             return null;
    }

   

}
