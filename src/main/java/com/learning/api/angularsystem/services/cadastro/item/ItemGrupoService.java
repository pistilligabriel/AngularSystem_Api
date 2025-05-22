package com.learning.api.angularsystem.services.cadastro.item;

import com.learning.api.angularsystem.entitys.cadastro.item.ItemGrupo;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.cadastro.item.ItemGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemGrupoService {
    
    @Autowired
    private ItemGrupoRepository repository;

    @Transactional
    public ItemGrupo createItemGrupo(ItemGrupo itemGrupo){
        return repository.save(itemGrupo);
    }

    @Transactional(readOnly = true)
    public List<ItemGrupo> getAllItemGrupos(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public ItemGrupo getById(Long codigo){
        return repository.findById(codigo).orElseThrow(
                () -> new RuntimeException("Item Grupo não encontrado")
        );
    }

    @Transactional()
    public ItemGrupo alterarStatus(Long codigo){
        ItemGrupo itemGrupo = getById(codigo);
        if(itemGrupo.getStatus().equals(Status.ATIVO)){
            itemGrupo.setStatusInativo();
        } else {
            itemGrupo.setStatusAtivo();
        }
        return itemGrupo;
    }

    @Transactional()
    public ItemGrupo deletarItemGrupo(Long codigo){
        ItemGrupo itemGrupo = getById(codigo);
        if(itemGrupo.getStatus().equals(Status.DESATIVADO)){
            repository.deleteById(itemGrupo.getCodigo());
        } else{
            throw new RuntimeException("Item Grupo não pode ser deletado!");
        }
        return itemGrupo;
    }
}
