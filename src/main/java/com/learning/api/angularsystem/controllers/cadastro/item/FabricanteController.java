package com.learning.api.angularsystem.controllers.cadastro.item;

import com.learning.api.angularsystem.dtos.cadastro.item.FabricanteDto;
import com.learning.api.angularsystem.entitys.cadastro.item.FabricanteEntity;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.cadastro.item.FabricanteRepository;
import com.learning.api.angularsystem.services.cadastro.item.FabricanteService;
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
@RequestMapping("/api/v1/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @PostMapping
    @Transactional
    public ResponseEntity<FabricanteEntity> cadastrarFabricante(@RequestBody @Valid FabricanteDto fabricanteDto) {
        return null;
    }

    @GetMapping
    public Iterable<FabricanteDto> listarFabricantes() {
        return null;
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<FabricanteDto> buscarFabricante(@PathVariable Long CODIGO) {
        return null;
    }

    @PutMapping
    @Transactional
    public ResponseEntity<FabricanteDto> atualizarFabricante(@RequestBody @Valid FabricanteDto fabricanteDto) {
        return null;
    }

    @PostMapping("/desativar/{CODIGO}")
    @Transactional
    public ResponseEntity<FabricanteDto> desativarFabricante(@PathVariable Long CODIGO) {
        return null;
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarFabricante(@PathVariable Long CODIGO) {
        return null;
    }
}
