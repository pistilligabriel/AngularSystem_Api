package com.learning.api.angularsystem.repositories.faturamento.pedido;

import com.learning.api.angularsystem.entitys.faturamento.pedido.PedidoDetalheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDetalheRepository extends JpaRepository<PedidoDetalheEntity, Long> {
}
