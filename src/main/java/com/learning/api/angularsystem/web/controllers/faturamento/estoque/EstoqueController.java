package com.learning.api.angularsystem.web.controllers.faturamento.estoque;

import com.learning.api.angularsystem.web.dtos.faturamento.estoque.EstoqueDto;
import com.learning.api.angularsystem.services.faturamento.estoque.EstoqueService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;


    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarEstoque(@RequestBody @Valid EstoqueDto estoqueDto) {
       return null;
    }

    @GetMapping
    public Iterable<EstoqueDto> listarEstoques() {
        return null;
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<EstoqueDto> buscarEstoque(Long CODIGO) {
       return null;
    }

    @PutMapping
    @Transactional
    public ResponseEntity<EstoqueDto> atualizarEstoque(@RequestBody @Valid EstoqueDto estoqueDto) {
        return null;
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarEstoque(Long CODIGO) {
        return null;
    }
}
