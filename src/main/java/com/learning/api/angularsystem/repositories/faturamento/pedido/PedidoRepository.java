package com.learning.api.angularsystem.repositories.faturamento.pedido;

import com.learning.api.angularsystem.entitys.faturamento.pedido.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
