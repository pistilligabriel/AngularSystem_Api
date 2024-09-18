package com.learning.api.angularsystem.controllers.faturamento.pedido;

import com.learning.api.angularsystem.dtos.faturamento.pedido.PedidoDetalheDto;
import com.learning.api.angularsystem.services.faturamento.pedido.PedidoDetalheService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pedido_detalhes")
public class PedidoDetalheController {

    @Autowired
    private PedidoDetalheService pedidoDetalheService;


    @PostMapping
    public ResponseEntity<Void> cadastrarPedidoDetalhe(@RequestBody @Valid PedidoDetalheDto pedidoDetalheDto) {
        return null;
    }

    @GetMapping
    public Iterable<PedidoDetalheDto> listarPedidoDetalhes() {
        return null;
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<PedidoDetalheDto> buscarPedidoDetalhe(Long CODIGO) {
        return null;
    }

    @PutMapping
    public ResponseEntity<PedidoDetalheDto> atualizarPedidoDetalhe(@RequestBody @Valid PedidoDetalheDto pedidoDetalheDto) {
        return null;
    }

    @PostMapping("/cancelar/{CODIGO}")
    public ResponseEntity<Void> cancelarPedidoDetalhe(Long CODIGO) {
        return null;
    }

    @DeleteMapping("/{CODIGO}")
    public ResponseEntity<Void> deletarPedidoDetalhe(Long CODIGO) {
        return null;
    }
}
