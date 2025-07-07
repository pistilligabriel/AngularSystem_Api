package com.learning.api.angularsystem.services.faturamento.pedido;

import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.entitys.faturamento.pedido.Pedido;
import com.learning.api.angularsystem.entitys.faturamento.pedido.PedidoDetalhe;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.faturamento.pedido.PedidoDetalheRepository;
import com.learning.api.angularsystem.repositories.faturamento.pedido.PedidoRepository;
import com.learning.api.angularsystem.services.cadastro.integrante.IntegranteService;
import com.learning.api.angularsystem.services.cadastro.item.ItemService;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemDto;
import com.learning.api.angularsystem.web.dtos.faturamento.pedido.PedidoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private IntegranteService integranteService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private PedidoDetalheRepository detalheRepository;

    @Transactional
    public Pedido criarPedido(PedidoDto pedidoDto) {

        Cliente cliente = integranteService.getIntegranteById(pedidoDto.getIntegrante().getCodigo());

        // Inserção de informações do pedido geral
        Pedido pedido = new Pedido();
        pedido.setIntegrante(cliente);
        pedido.setDataEmissao(LocalDateTime.now());
        pedido.setFormaPagamento(pedidoDto.getFormaPagamento());
        pedido.setParcelas(pedidoDto.getParcelas());
        pedido.setPorcentagemDesconto(pedidoDto.getPorcentagemDesconto());
        pedido.setDesconto(pedidoDto.getDesconto());
        pedido.setLucro(pedidoDto.getLucro());
        pedido.setTotalSemDesconto(pedidoDto.getTotalSemDesconto());
        pedido.setTotal(pedidoDto.getTotal());

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        int ordem = 1;

        for (ItemDto itemDto : pedidoDto.getProdutos()) {
            // ⚠️ Buscar o item existente pelo código
            Item itemExistente = itemService.buscarProduto(itemDto.getCodigo());

            // Inserção das informações do detalhe (Produtos) do pedido.
            PedidoDetalhe detalhe = new PedidoDetalhe();
            detalhe.setPedido(pedidoSalvo);
            detalhe.setItem(itemExistente);
            detalhe.setDescricao(itemDto.getDescricao());
            detalhe.setOrdem(ordem++);
            detalhe.setQuantidade(itemDto.getQuantidade());
            detalhe.setValorUnitario(itemDto.getPrecoVenda());
            detalhe.setValorTotal(itemDto.getPrecoVenda() * itemDto.getQuantidade());
            itemExistente.setEstoque(itemDto.getEstoque() - itemDto.getQuantidade());


            detalheRepository.save(detalhe);
        }

        return pedidoSalvo;
    }

    public ResponseEntity<Void> atualizarPedido(){
//        PedidoEntity pedido = pedidoRepository.findById(pedidoDto.CODIGO())
//                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
//
//        pedido.atualizarPedido(pedidoDto);
//
//        if (pedidoDto.integrante() != null) {
//            IntegranteEntity integrante = integranteRepository.findById(pedidoDto.integrante().getCODIGO())
//                    .orElseThrow(() -> new RuntimeException("Integrante não encontrado"));
//
//            pedido.setIntegrante(integrante);
//        } else {
//            pedido.setIntegrante(null);
//        }
//
//        pedidoRepository.save(pedido);
//
//        return ResponseEntity.ok(new PedidoDto(pedido));
        return null;
    }

    @Transactional(readOnly = true)
    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Pedido não encontrado")
        );
    }

    @Transactional()
    public PedidoDetalhe salvarDetalhe(Long codigo, PedidoDetalhe detalhe) {
        Pedido pedido = buscarPedidoPorId(codigo);

        Item item = itemService.buscarProduto(detalhe.getItem().getCodigo());

        PedidoDetalhe pedidoDetalhe = new PedidoDetalhe();
        pedidoDetalhe.setPedido(pedido);
        pedidoDetalhe.setStatus(Status.ATIVO);
        pedidoDetalhe.setItem(item);
        pedidoDetalhe.setDescricao(item.getDescricao());
        return detalheRepository.save(pedidoDetalhe);
    }

    @Transactional(readOnly = true)
    public List<Pedido> buscarPedidos() {
        return pedidoRepository.findAllWithDetalhes();
    }

    @Transactional(readOnly = true)
    public Pedido buscarPedidoComRelacionamentos(Long id) {
        Pedido pedido = pedidoRepository.findByIdComRelacionamentos(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));


        // Aqui os detalhes já estão carregados e prontos para uso
        pedido.getDetalhes().forEach(d -> {
            Item itemExistente = itemService.buscarProduto(d.getCodigo());
            System.out.println(d.getCodigo() + " " + d.getDescricao() + " " + itemExistente.getEstoque());
        });



        return pedido;
    }

    @Transactional
    public Pedido cancelarPedido(Long id){
        Pedido pedido = buscarPedidoComRelacionamentos(id);
        pedido.setStatus(Status.CANCELADO);
        // Aqui os detalhes já estão carregados e prontos para uso
        pedido.getDetalhes().forEach(d -> {
            Item itemExistente = itemService.buscarProduto(d.getCodigo());
            d.setStatus(Status.CANCELADO);
            itemExistente.setEstoque(itemExistente.getEstoque() + d.getQuantidade());
        });
        return pedidoRepository.save(pedido);
    }
}
