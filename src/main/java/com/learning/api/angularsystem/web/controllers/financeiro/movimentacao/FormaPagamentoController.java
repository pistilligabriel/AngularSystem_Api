package com.learning.api.angularsystem.web.controllers.financeiro.movimentacao;

import com.learning.api.angularsystem.services.financeiro.FormaPagamentoService;
import com.learning.api.angularsystem.web.dtos.financeiro.movimentacao.FormaPagamentoDto;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.entitys.financeiro.movimentacao.*;
import com.learning.api.angularsystem.repositories.financeiro.movimentacao.FormaPagamentoRepository;
import com.learning.api.angularsystem.web.dtos.financeiro.movimentacao.ResponseFormaPagamentoDto;
import com.learning.api.angularsystem.web.dtos.financeiro.movimentacao.mapper.FormaPagamentoMapper;
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
@RequestMapping("/api/v1/formas_pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @PostMapping
    public ResponseEntity<ResponseFormaPagamentoDto> cadastrarFormaPagamento(@RequestBody @Valid FormaPagamentoDto formaPagamentoDto) {
        FormaPagamentoEntity formaPagamento = formaPagamentoService.criarFormaPagamento(FormaPagamentoMapper.toFormaPagamento(formaPagamentoDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(FormaPagamentoMapper.toDto(formaPagamento));
    }

    @GetMapping
    public ResponseEntity<List<ResponseFormaPagamentoDto>> listarFormasPagamento() {
        List<FormaPagamentoEntity> formaPagamento = formaPagamentoService.buscarFormasPagamento();
        return ResponseEntity.status(HttpStatus.OK).body(FormaPagamentoMapper.toListDto(formaPagamento));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ResponseFormaPagamentoDto> buscarFormaPagamento(Long codigo) {
        FormaPagamentoEntity formaPagamento = formaPagamentoService.buscarFormaPagamentoPorId(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(FormaPagamentoMapper.toDto(formaPagamento));
    }

    @PutMapping
    public ResponseEntity<ResponseFormaPagamentoDto> atualizarFormaPagamento(@RequestBody @Valid FormaPagamentoDto formaPagamentoDto) {
        return null;
    }

    @PostMapping("/status/{codigo}")
    public ResponseEntity<ResponseFormaPagamentoDto> ativarFormaPagamento(@PathVariable Long codigo) {
        FormaPagamentoEntity formaPagamento = formaPagamentoService.alterarStatus(codigo);

        return ResponseEntity.status(HttpStatus.OK).body(FormaPagamentoMapper.toDto(formaPagamento));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<ResponseFormaPagamentoDto> deletarFormaPagamento(@PathVariable Long codigo) {
        FormaPagamentoEntity formaPagamento = formaPagamentoService.deletarFormaPagamento(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(FormaPagamentoMapper.toDto(formaPagamento));
    }
}
