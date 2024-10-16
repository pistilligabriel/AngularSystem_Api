package com.learning.api.angularsystem.web.controllers.faturamento.pedido;

import com.learning.api.angularsystem.web.dtos.faturamento.pedido.PedidoDto;
import com.learning.api.angularsystem.services.faturamento.pedido.PedidoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;



    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarPedido(@RequestBody @Valid PedidoDto pedidoDto) {
        return null;
    }

    @GetMapping
    public Iterable<PedidoDto> listarPedidos() {
        return null;
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<PedidoDto> buscarPedido(Long CODIGO) {
        return null;
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PedidoDto> atualizarPedido(@RequestBody @Valid PedidoDto pedidoDto) {
       return null;
    }

    @PostMapping("/cancelar/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> cancelarPedido(@PathVariable Long CODIGO) {
        return null;
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarPedido(@PathVariable Long CODIGO) {
        return null;
    }
}
