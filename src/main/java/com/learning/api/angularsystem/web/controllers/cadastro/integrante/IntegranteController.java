package com.learning.api.angularsystem.web.controllers.cadastro.integrante;

import com.learning.api.angularsystem.web.dtos.cadastro.integrante.ClienteDto;
import com.learning.api.angularsystem.web.dtos.cadastro.integrante.ClienteResponseDto;
import com.learning.api.angularsystem.web.dtos.cadastro.integrante.mapper.ClienteMapper;
import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import com.learning.api.angularsystem.services.cadastro.integrante.IntegranteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class IntegranteController {

    @Autowired
    private IntegranteService integranteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDto> cadastrarIntegrante(@RequestBody @Valid ClienteDto clienteDto) {
        Cliente integrante = integranteService.criarIntegrante(ClienteMapper.toCliente(clienteDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteMapper.toDto(integrante));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> listarIntegrantes() {
        List<Cliente> integrantes = integranteService.getTodosIntegrantes();
        return ResponseEntity.status(HttpStatus.OK).body(ClienteMapper.toListDto(integrantes));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ClienteResponseDto> buscarIntegrante(@PathVariable Long codigo) {
        Cliente integrante = integranteService.getIntegranteById(codigo);

        return ResponseEntity.ok().body(ClienteMapper.toDto(integrante));
    }

    @PutMapping
    public ResponseEntity<ClienteResponseDto> atualizarIntegrante(@RequestBody @Valid ClienteDto integranteDto) {
        Cliente cliente = integranteService.atualizarIntegrante(ClienteMapper.toCliente(integranteDto));
        // Retorna a resposta com o DTO atualizado
        return ResponseEntity.status(HttpStatus.OK).body(ClienteMapper.toDto(cliente));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<ClienteResponseDto> deletarIntegrante(@PathVariable Long codigo) {
        integranteService.deletarIntegrante(codigo);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/desativar/{codigo}")
    public ResponseEntity<ClienteResponseDto> alterarStatusIntegrante(@PathVariable Long codigo) {
        integranteService.alterarStatus(codigo);
        return ResponseEntity.noContent().build();
    }

}