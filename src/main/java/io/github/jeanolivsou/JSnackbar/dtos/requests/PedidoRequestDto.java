package io.github.jeanolivsou.JSnackbar.dtos.requests;

import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PedidoRequestDto {
    private Integer id;
    private String status;
    private Date dataPedido;
    private Cliente cliente;
    private List<ItemPedidoRequestDto> itens;
    private Double total;
}
