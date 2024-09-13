package com.learning.api.angularsystem.controllers.financeiro.movimentacao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movimentacoes")
public class MovimentacaoController {
/*
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;
    @Autowired
    private TituloRepository tituloRepository;
    @Autowired
    private IntegranteRepository integranteRepository;
    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarMovimentacao(@RequestBody @Valid MovimentacaoDto movimentacaoDto) {
        MovimentacaoEntity movimentacao = new MovimentacaoEntity(movimentacaoDto);

        if (movimentacaoDto.titulo() != null) {
            tituloRepository.findById(movimentacaoDto.titulo().getCODIGO())
                    .ifPresent(movimentacao::setTitulo);
        }

        if (movimentacaoDto.integrante() != null) {
            integranteRepository.findById(movimentacaoDto.integrante().getCODIGO())
                    .ifPresent(movimentacao::setIntegrante);
        }

        if (movimentacaoDto.formaPagamento() != null) {
            formaPagamentoRepository.findById(movimentacaoDto.formaPagamento().getCODIGO())
                    .ifPresent(movimentacao::setFormaPagamento);
        }

        movimentacaoRepository.save(movimentacao);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<MovimentacaoDto> listarMovimentacoes() {
        return movimentacaoRepository.findAll().stream().map(MovimentacaoDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<MovimentacaoDto> buscarMovimentacao(Long CODIGO) {
        var movimentacao = movimentacaoRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new MovimentacaoDto(movimentacao));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<MovimentacaoDto> atualizarMovimentacao(@RequestBody @Valid MovimentacaoDto movimentacaoDto) {
        MovimentacaoEntity movimentacao = movimentacaoRepository.findById(movimentacaoDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Movimentacao não encontrada"));

        movimentacao.atualizarMovimentacao(movimentacaoDto);

        if(movimentacaoDto.titulo() != null) {
            tituloRepository.findById(movimentacaoDto.titulo().getCODIGO())
                    .ifPresent(movimentacao::setTitulo);
        } else {
            movimentacao.setTitulo(null);
        }

        if(movimentacaoDto.integrante() != null) {
            integranteRepository.findById(movimentacaoDto.integrante().getCODIGO())
                    .ifPresent(movimentacao::setIntegrante);
        } else {
            movimentacao.setIntegrante(null);
        }

        if(movimentacaoDto.formaPagamento() != null) {
            formaPagamentoRepository.findById(movimentacaoDto.formaPagamento().getCODIGO())
                    .ifPresent(movimentacao::setFormaPagamento);
        } else {
            movimentacao.setFormaPagamento(null);
        }

        movimentacaoRepository.save(movimentacao);

        return ResponseEntity.ok(new MovimentacaoDto(movimentacao));
    }

    @PostMapping("/cancelar/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> cancelarMovimentacao(@PathVariable Long CODIGO) {
        var movimentacao = movimentacaoRepository.getReferenceById(CODIGO);

        if (movimentacao.getStatus().equals("CANCELADO")) {
            movimentacao.setStatusCancelado();
        } else {
            movimentacao.setStatusNormal();
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarMovimentacao(@PathVariable Long CODIGO) {
        movimentacaoRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }*/


}
