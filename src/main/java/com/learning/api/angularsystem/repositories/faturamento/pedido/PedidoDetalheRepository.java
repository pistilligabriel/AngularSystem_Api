package com.learning.api.angularsystem.repositories.faturamento.pedido;

import com.learning.api.angularsystem.entitys.faturamento.pedido.PedidoDetalhe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDetalheRepository extends JpaRepository<PedidoDetalhe, Long> {
}
