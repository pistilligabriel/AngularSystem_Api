package com.learning.api.angularsystem.controllers.cadastro.item;

import com.learning.api.angularsystem.dtos.cadastro.item.UnidadeMedidaDto;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedidaEntity;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.cadastro.item.UnidadeMedidaRepository;
import com.learning.api.angularsystem.services.cadastro.item.UnidadeMedidaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v1/unidade-medida")
public class UnidadeMedidaController {

    @Autowired
    private UnidadeMedidaService unidadeMedidaService;

    @PostMapping
    @Transactional
    public ResponseEntity<UnidadeMedidaEntity> cadastrarUnidadeMedida(@RequestBody @Valid UnidadeMedidaDto unidadeMedidaDto) {
        return null;
    }

    @GetMapping
    public Iterable<UnidadeMedidaDto> listarUnidadeMedida() {
        return null;
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<UnidadeMedidaDto> buscarUnidadeMedida(@PathVariable Long CODIGO) {
        return null;
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UnidadeMedidaDto> atualizarUnidadeMedida(@RequestBody @Valid UnidadeMedidaDto unidadeMedidaDto) {
        return null;
    }

    @PostMapping("/desativar/{CODIGO}")
    @Transactional
    public ResponseEntity<UnidadeMedidaDto> desativarUnidadeMedida(@PathVariable Long CODIGO) {
        return null;
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarUnidadeMedida(@PathVariable Long CODIGO) {
        return null;
    }
}
