package com.learning.api.angularsystem.services.cadastro.item;

import com.learning.api.angularsystem.entitys.cadastro.item.Fabricante;
import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedida;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.cadastro.item.ItemRepository;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FabricanteService fabricanteService;

    @Autowired
    private UnidadeMedidaService unidadeService;

    @Transactional()
    public Item salvar(Item item){
        return itemRepository.save(item);
    }

    @Transactional()
    public Item criarItem(ItemDto item){
        Item itemEntity = new Item();

        itemEntity.setDataCadastro(LocalDateTime.now());
        itemEntity.setDescricao(item.getDescricao());
        itemEntity.setTipoProduto(item.getTipoProduto());
        itemEntity.setObservacao(item.getObservacao());
        itemEntity.setPrecoCusto(item.getPrecoCusto());
        itemEntity.setPrecoVenda(item.getPrecoVenda());
        itemEntity.setEstoque(item.getEstoque());
        itemEntity.setMargemLucro(itemEntity.calcularMargemLucro());
        itemEntity.setModelo(item.getModelo());
        Fabricante fabricante = fabricanteService.getById( item.getFabricante());
        itemEntity.setFabricante(fabricante);


        UnidadeMedida unidade = unidadeService.getById(item.getUnidadeVenda());
        itemEntity.setUnidadeVenda(unidade);
        return itemRepository.save(itemEntity);
    }
    @Transactional(readOnly = true)
    public List<Item> listarProdutos(){
        return itemRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Item buscarProduto(Long codigo){
        return itemRepository.findById(codigo).orElseThrow(
                () -> new RuntimeException("Produto não encontrado!")
        );
    }

    @Transactional()
    public Item alterarStatus(Long codigo){
        Item item = buscarProduto(codigo);
        if(item.getStatus().equals(Status.ATIVO) && item.getEstoque() == 0){
            item.setStatusInativo();
        } else if(item.getStatus().equals(Status.ATIVO) && item.getEstoque() > 0){
            throw new RuntimeException("Não é possível desativar produto com estoque!");
        } else {
            item.setStatusAtivo();
        }
        return item;
    }

    @Transactional()
    public Item deletarProduto(Long codigo){
        Item item = buscarProduto(codigo);
        if(item.getStatus().equals(Status.DESATIVADO)){
            itemRepository.deleteById(item.getCodigo());
        } else{
            throw new RuntimeException("Produto não pode ser deletado!");
        }
        return item;
    }

    @Transactional()
    public Item editarItem(Item item){
        Item itemAtualizar = buscarProduto(item.getCodigo());

        if(!itemAtualizar.getStatus().equals(Status.ATIVO)){
            throw new RuntimeException("Unidade não pode ser alterada, pois está desativada!");
        }

        itemAtualizar.setDescricao(item.getDescricao());
        itemAtualizar.setTipoProduto(item.getTipoProduto());
        itemAtualizar.setModelo(item.getModelo());
        itemAtualizar.setGrupoItem(item.getGrupoItem());
        itemAtualizar.setObservacao(item.getObservacao());
        itemAtualizar.setUnidadeVenda(item.getUnidadeVenda());
        itemAtualizar.setFabricante(item.getFabricante());
        itemAtualizar.setPrecoCusto(item.getPrecoCusto());
        itemAtualizar.setPrecoVenda(item.getPrecoVenda());
        itemAtualizar.setVersao(LocalDateTime.now());

        itemAtualizar.calcularMargemLucro();

        return itemRepository.save(itemAtualizar);
    }

    @Transactional
    public Item acertoEstoqueProduto(Long codigo, Double estoque){
        Item item = buscarProduto(codigo);
        if(item.getStatus().equals(Status.ATIVO)){
            if(item.getEstoque() + estoque < 0 ){
                throw new RuntimeException("Quantidade não pode ser negativa");
            }
            item.setEstoque(item.getEstoque() + estoque);
        }
        return salvar(item);
    }

}
