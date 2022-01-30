package io.github.jeanolivsou.JSnackbar.repositories;

import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
