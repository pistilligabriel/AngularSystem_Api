package com.learning.api.angularsystem.web.controllers.financeiro.titulo;

import com.learning.api.angularsystem.services.financeiro.TituloService;
import com.learning.api.angularsystem.web.dtos.financeiro.titulo.TituloDto;
import com.learning.api.angularsystem.entitys.financeiro.titulo.TituloEntity;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.web.dtos.financeiro.titulo.TituloResponseDto;
import com.learning.api.angularsystem.web.dtos.financeiro.titulo.mapper.TituloMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/titulos")
public class TituloController {

    @Autowired
    private TituloService tituloService;

    @PostMapping
    public ResponseEntity<TituloResponseDto> cadastrarTitulo(@RequestBody @Valid TituloDto tituloDto) {
        TituloEntity titulo = tituloService.criarTitulo(TituloMapper.toTitulo(tituloDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(TituloMapper.toDto(titulo));
    }

    @GetMapping
    public ResponseEntity<List<TituloResponseDto>> listarTitulos() {
        List<TituloEntity> titulos = tituloService.buscarTitulos();
        return ResponseEntity.status(HttpStatus.OK).body(TituloMapper.toListDto(titulos));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<TituloResponseDto> buscarTitulo(Long codigo) {
        TituloEntity titulo = tituloService.buscarTituloPorId(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(TituloMapper.toDto(titulo));
    }

    @PutMapping
    public ResponseEntity<TituloResponseDto> atualizarTitulo(@RequestBody @Valid TituloDto tituloDto) {
        return null;
    }

    @PatchMapping("/cancelar/{codigo}")
    public ResponseEntity<TituloResponseDto> cancelarTitulo(@PathVariable Long codigo) {
        TituloEntity titulo = tituloService.cancelarTitulo(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(TituloMapper.toDto(titulo));
    }


}
