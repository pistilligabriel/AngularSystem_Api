package com.learning.api.angularsystem.web.controllers.cadastro.item;

import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.entitys.cadastro.item.ItemGrupo;
import com.learning.api.angularsystem.web.dtos.cadastro.item.UnidadeMedidaDto;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedida;
import com.learning.api.angularsystem.services.cadastro.item.UnidadeMedidaService;
import com.learning.api.angularsystem.web.dtos.cadastro.item.UnidadeMedidaResponseDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.mapper.ItemGrupoMapper;
import com.learning.api.angularsystem.web.dtos.cadastro.item.mapper.ItemMapper;
import com.learning.api.angularsystem.web.dtos.cadastro.item.mapper.UnidadeMedidaMapper;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/unidade-medida")
public class UnidadeMedidaController {

    @Autowired
    private UnidadeMedidaService service;

    @PostMapping
    public ResponseEntity<UnidadeMedidaResponseDto> cadastrarUnidadeMedida(@RequestBody @Valid UnidadeMedidaDto unidadeMedidaDto) {
        UnidadeMedida unidadeMedida = service.createUnidadeMedida(UnidadeMedidaMapper.toUnidadeMedida(unidadeMedidaDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UnidadeMedidaMapper.toDto(unidadeMedida));
    }

    @GetMapping
    public ResponseEntity<List<UnidadeMedidaResponseDto>> listarUnidadeMedida() {
        List<UnidadeMedida> unidadeMedida = service.getAllUnidadeMedidas();
        return ResponseEntity.status(HttpStatus.OK).body(UnidadeMedidaMapper.toListDto(unidadeMedida));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<UnidadeMedidaResponseDto> buscarUnidadeMedida(@PathVariable Long codigo) {
        UnidadeMedida unidadeMedida = service.getById(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(UnidadeMedidaMapper.toDto(unidadeMedida));
    }

    @PutMapping
    public ResponseEntity<UnidadeMedidaResponseDto> atualizarUnidadeMedida(@RequestBody @Valid UnidadeMedidaDto unidadeMedidaDto) {
        return null;
    }

    @PostMapping("/alterar-status/{codigo}")
    public ResponseEntity<UnidadeMedidaResponseDto> alterarStatusUnidadeMedida(@PathVariable Long codigo) {
       service.alterarStatus(codigo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<UnidadeMedidaResponseDto> deletarUnidadeMedida(@PathVariable Long codigo) {
        service.deletarUnidadeMedida(codigo);
        return ResponseEntity.noContent().build();
    }
}
