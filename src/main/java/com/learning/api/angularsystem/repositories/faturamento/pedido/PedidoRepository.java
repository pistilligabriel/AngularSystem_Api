package com.learning.api.angularsystem.repositories.faturamento.pedido;

import com.learning.api.angularsystem.entitys.faturamento.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("SELECT DISTINCT p FROM Pedido p " +
            "LEFT JOIN FETCH p.integrante " +
            "LEFT JOIN FETCH p.detalhes d " +
            "LEFT JOIN FETCH d.item i " +
            "LEFT JOIN FETCH i.unidadeVenda " +
            "LEFT JOIN FETCH i.fabricante")
    List<Pedido> findAllWithDetalhes();

    @Query("SELECT p FROM Pedido p LEFT JOIN FETCH p.integrante WHERE p.codigo = :codigo")
    Optional<Pedido> findByIdWithIntegrante(@Param("codigo") Long codigo);
}
