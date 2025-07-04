package com.learning.api.angularsystem.web.controllers.faturamento.pedido;

import com.learning.api.angularsystem.entitys.faturamento.pedido.Pedido;
import com.learning.api.angularsystem.entitys.faturamento.pedido.PedidoDetalhe;
import com.learning.api.angularsystem.services.faturamento.pedido.PedidoService;
import com.learning.api.angularsystem.web.dtos.faturamento.pedido.DetalheResponseDto;
import com.learning.api.angularsystem.web.dtos.faturamento.pedido.PedidoDetalheDto;
import com.learning.api.angularsystem.web.dtos.faturamento.pedido.PedidoDto;
import com.learning.api.angularsystem.web.dtos.faturamento.pedido.ResponsePedidoDto;
import com.learning.api.angularsystem.web.dtos.faturamento.pedido.mapper.PedidoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;



    @PostMapping
    public ResponseEntity<ResponsePedidoDto> cadastrarPedido(@RequestBody @Valid PedidoDto pedidoDto) {
        Pedido pedido = pedidoService.criarPedido(pedidoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(PedidoMapper.toDto(pedido));
    }

    @GetMapping
    public ResponseEntity<List<ResponsePedidoDto>> listarPedidos() {
        List<Pedido> pedidos = pedidoService.buscarPedidos();
        pedidos.forEach(p -> System.out.println("Integrante: " + p.getIntegrante()));
        return ResponseEntity.status(HttpStatus.OK).body(PedidoMapper.toResponseListDto(pedidos));
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<ResponsePedidoDto> buscarPedido(Long CODIGO) {
        return null;
    }

    @PutMapping
    public ResponseEntity<ResponsePedidoDto> atualizarPedido(@RequestBody @Valid PedidoDto pedidoDto) {
       return null;
    }

    @PostMapping("/cancelar/{CODIGO}")
    public ResponseEntity<ResponsePedidoDto> cancelarPedido(@PathVariable Long CODIGO) {
        return null;
    }

    @DeleteMapping("/{CODIGO}")
    public ResponseEntity<ResponsePedidoDto> deletarPedido(@PathVariable Long CODIGO) {
        return null;
    }

    @PatchMapping("{codigo}/detalhe")
    public ResponseEntity<DetalheResponseDto> adicionarDetalhe(@PathVariable Long codigo,
                                                            @RequestBody PedidoDetalheDto dto) {
        PedidoDetalhe detalhe = pedidoService.salvarDetalhe(codigo, PedidoMapper.toDetalhe(dto) );
        return ResponseEntity.ok(PedidoMapper.toDto(detalhe));
    }
}
