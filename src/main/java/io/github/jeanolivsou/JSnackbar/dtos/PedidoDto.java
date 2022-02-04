package io.github.jeanolivsou.JSnackbar.dtos;

import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {
    private String Status;
    private Date dataPedido;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Double total;

    public PedidoDto(Pedido pedido) {
        this.Status = pedido.getStatus();
        this.dataPedido = pedido.getDataPedido();
        this.cliente = pedido.getCliente();
        this.itens = pedido.getItens();
        this.total = pedido.getTotal();
    }

}
