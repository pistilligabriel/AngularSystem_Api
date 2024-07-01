package com.learning.api.minisys.controllers.cadastro.usuario;

import com.learning.api.minisys.dtos.cadastro.usuario.UsuarioDto;
import com.learning.api.minisys.dtos.cadastro.usuario.table.UsuarioTableDto;
import com.learning.api.minisys.entitys.cadastro.usuario.UsuarioEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.cadastro.integrante.IntegranteRepository;
import com.learning.api.minisys.repositories.cadastro.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private IntegranteRepository integranteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        // Cria uma nova instância de UsuarioEntity a partir do DTO
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDto);

        // Salva o usuário no banco de dados
        usuarioRepository.save(usuarioEntity);

        // Retorna uma resposta de criação (status 201)
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<UsuarioTableDto> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(UsuarioTableDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<UsuarioDto> buscarUsuario(@PathVariable Long CODIGO) {
        var usuario = usuarioRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new UsuarioDto(usuario));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UsuarioDto> atualizarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {

            // Busca a entidade existente no banco de dados
            UsuarioEntity usuario = usuarioRepository.findById(usuarioDto.CODIGO())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            // Atualiza os dados da entidade existente com base nos dados recebidos no DTO
            usuario.atualizarUsuario(usuarioDto);

            // Salva as alterações no banco de dados
            usuarioRepository.save(usuario);

            // Retorna uma resposta com o DTO atualizado
            return ResponseEntity.ok(new UsuarioDto(usuario));
    }


    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long CODIGO) {
        usuarioRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/desativar/{CODIGO}")
    @Transactional
    public ResponseEntity<UsuarioDto> ativarUsuario(@PathVariable Long CODIGO) {
        var usuario = usuarioRepository.getReferenceById(CODIGO);

        if(usuario.getStatus().equals(Status.ATIVO)) {
            usuario.setStatusInativo();
        } else {
            usuario.setStatusAtivo();
        }

        return ResponseEntity.ok(new UsuarioDto(usuario));
    }



}
