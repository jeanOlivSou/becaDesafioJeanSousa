package io.github.jeanolivsou.JSnackbar.repositories;

import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
