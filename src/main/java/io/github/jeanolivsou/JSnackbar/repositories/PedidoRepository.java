package io.github.jeanolivsou.JSnackbar.repositories;

import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
