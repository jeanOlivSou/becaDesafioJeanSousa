package io.github.jeanolivsou.JSnackbar.dtos.responses;

import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseDto {
    private String status;
    private LocalDateTime dataPedido = LocalDateTime.now();
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Double total;

}
