package com.learning.api.angularsystem.repositories.cadastro.item;

import com.learning.api.angularsystem.entitys.cadastro.item.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
