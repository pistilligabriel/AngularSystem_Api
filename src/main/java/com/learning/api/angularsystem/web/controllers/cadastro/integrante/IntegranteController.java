package com.learning.api.angularsystem.web.controllers.cadastro.integrante;

import com.learning.api.angularsystem.web.dtos.cadastro.integrante.IntegranteDto;
import com.learning.api.angularsystem.web.dtos.cadastro.integrante.IntegranteResponseDto;
import com.learning.api.angularsystem.web.dtos.cadastro.integrante.mapper.IntegranteMapper;
import com.learning.api.angularsystem.entitys.cadastro.integrante.IntegranteEntity;
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
    public ResponseEntity<IntegranteResponseDto> cadastrarIntegrante(@RequestBody @Valid IntegranteDto integranteDto) {
        IntegranteEntity integrante = integranteService.criarIntegrante(IntegranteMapper.toIntegrante(integranteDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(IntegranteMapper.toDto(integrante));
    }

    @GetMapping
    public ResponseEntity<List<IntegranteResponseDto>> listarIntegrantes() {
        List<IntegranteEntity> integrantes = integranteService.getTodosIntegrantes();
        return ResponseEntity.status(HttpStatus.OK).body(IntegranteMapper.toListDto(integrantes));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<IntegranteResponseDto> buscarIntegrante(@PathVariable Long codigo) {
        IntegranteEntity integrante = integranteService.getIntegranteById(codigo);

        return ResponseEntity.ok().body(IntegranteMapper.toDto(integrante));
    }

   /* @PutMapping
    public ResponseEntity<IntegranteDto> atualizarIntegrante(@RequestBody @Valid IntegranteDto integranteDto) {


        // Retorna a resposta com o DTO atualizado
        return ResponseEntity.ok(new IntegranteDto(integrante));
    }
*/
    @DeleteMapping("/{codigo}")
    public ResponseEntity<IntegranteResponseDto> deletarIntegrante(@PathVariable Long codigo) {
        integranteService.deletarIntegrante(codigo);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/desativar/{codigo}")
    public ResponseEntity<IntegranteResponseDto> desativarIntegrante(@PathVariable Long codigo) {
        IntegranteEntity integrante = integranteService.alterarStatus(codigo);
        return ResponseEntity.ok().body(IntegranteMapper.toDto(integrante));
    }

}