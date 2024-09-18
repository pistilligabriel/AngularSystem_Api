package com.learning.api.angularsystem.services.cadastro.usuario;

import com.learning.api.angularsystem.dtos.cadastro.usuario.AuthenticationDto;
import com.learning.api.angularsystem.dtos.cadastro.usuario.LoginResponseDto;
import com.learning.api.angularsystem.entitys.cadastro.usuario.UsuarioEntity;
import com.learning.api.angularsystem.infra.security.TokenService;
import com.learning.api.angularsystem.repositories.cadastro.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity login(AuthenticationDto authenticationDto){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDto.getLogin(), authenticationDto.getPassword());
        var authentication = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UsuarioEntity) authentication.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

}
