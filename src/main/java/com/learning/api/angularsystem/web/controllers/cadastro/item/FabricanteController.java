package com.learning.api.angularsystem.web.controllers.cadastro.item;

import com.learning.api.angularsystem.entitys.cadastro.item.Fabricante;
import com.learning.api.angularsystem.services.cadastro.item.FabricanteService;
import com.learning.api.angularsystem.web.dtos.cadastro.item.FabricanteDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.FabricanteResponseDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.mapper.FabricanteMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteService service;

    @PostMapping
    @Transactional
    public ResponseEntity<FabricanteResponseDto> cadastrarFabricante(@RequestBody @Valid FabricanteDto fabricanteDto) {
        Fabricante fabricante = service.createFabricante(FabricanteMapper.toFabricante(fabricanteDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(FabricanteMapper.toDto(fabricante));
    }

    @GetMapping
    public ResponseEntity<List<FabricanteResponseDto>> listarFabricantes() {
        List<Fabricante> fabricantes = service.getAllFabricantes();
        return ResponseEntity.status(HttpStatus.OK).body(FabricanteMapper.toListDto(fabricantes));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<FabricanteResponseDto> buscarFabricante(@PathVariable Long codigo) {
        Fabricante fabricante = service.getById(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(FabricanteMapper.toDto(fabricante));
    }

    @PutMapping
    public ResponseEntity<FabricanteResponseDto> editarFabricante(@RequestBody @Valid FabricanteDto fabricanteDto) {
        Fabricante fabricante = service.editarFabricante(FabricanteMapper.toFabricante(fabricanteDto));
        return ResponseEntity.status(HttpStatus.OK).body(FabricanteMapper.toDto(fabricante));
    }

    @PostMapping("/alterar-status/{codigo}")
    public ResponseEntity<FabricanteResponseDto> desativarFabricante(@PathVariable Long codigo) {
        Fabricante fabricante = service.alterarStatus(codigo);
        return ResponseEntity.ok().body(FabricanteMapper.toDto(fabricante));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<FabricanteResponseDto> deletarFabricante(@PathVariable Long codigo) {
        service.deletarFabricante(codigo);
        return ResponseEntity.noContent().build();
    }
}
