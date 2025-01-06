package com.learning.api.angularsystem.web.controllers.cadastro.item;

import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.entitys.cadastro.item.ItemGrupo;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemGrupoDto;
import com.learning.api.angularsystem.services.cadastro.item.ItemGrupoService;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemGrupoResponseDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.mapper.ItemGrupoMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
@RequestMapping("/api/v1/item-grupos")
public class ItemGrupoController {

    @Autowired
    private ItemGrupoService service;

    @PostMapping
    public ResponseEntity<ItemGrupoResponseDto> cadastrarItemGrupo(@RequestBody @Valid ItemGrupoDto itemGrupoDto) {
        ItemGrupo itemGrupo = service.createItemGrupo(ItemGrupoMapper.toItemGrupo(itemGrupoDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ItemGrupoMapper.toDto(itemGrupo));
    }

    @GetMapping
    public ResponseEntity<List<ItemGrupoResponseDto>> listarItemGrupos() {
        List<ItemGrupo> itensGrupo = service.getAllItemGrupos();
        return ResponseEntity.status(HttpStatus.OK).body(ItemGrupoMapper.toListDto(itensGrupo));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ItemGrupoResponseDto> buscarItemGrupo(@PathVariable Long codigo) {
        ItemGrupo itemGrupo = service.getById(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(ItemGrupoMapper.toDto(itemGrupo));
    }

    @PutMapping
    public ResponseEntity<ItemGrupoResponseDto> atualizarItemGrupo(@RequestBody @Valid ItemGrupoDto itemGrupoDto) {
        return null;
    }

    @PostMapping("/alterar-status/{codigo}")
    public ResponseEntity<ItemGrupoResponseDto> desativarItemGrupo(@PathVariable Long codigo) {
        service.alterarStatus(codigo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<ItemGrupoResponseDto> deletarItemGrupo(@PathVariable Long codigo) {
        service.deletarItemGrupo(codigo);
        return ResponseEntity.noContent().build();
    }
}
