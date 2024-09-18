package com.learning.api.angularsystem.controllers.cadastro.usuario;

import com.learning.api.angularsystem.dtos.cadastro.usuario.UsuarioDto;
import com.learning.api.angularsystem.repositories.cadastro.integrante.IntegranteRepository;
import com.learning.api.angularsystem.services.cadastro.usuario.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IntegranteRepository integranteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        return null;
    }

    @GetMapping
    public Iterable<UsuarioDto> listarUsuarios() {
        return null;
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<UsuarioDto> buscarUsuario(@PathVariable Long CODIGO) {
        return null;
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UsuarioDto> atualizarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {

        return null;
    }


    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long CODIGO) {
        return null;
    }

    @PostMapping("/desativar/{CODIGO}")
    @Transactional
    public ResponseEntity<UsuarioDto> ativarUsuario(@PathVariable Long CODIGO) {
        return null;
    }



}
