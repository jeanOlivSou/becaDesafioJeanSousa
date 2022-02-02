package io.github.jeanolivsou.JSnackbar.dtos;

import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
public class PedidoDto {
    private String Status;
    private Date dataPedido;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Double total;


    public PedidoDto(String status, Date dataPedido, Cliente cliente, List<ItemPedido> itens, Double total) {
        this.Status = status;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.itens = itens;
        this.total = total;
    }

    public PedidoDto(Pedido pedido) {
        this.Status = pedido.getStatus();
        this.dataPedido = pedido.getDataPedido();
        this.cliente = pedido.getCliente();
        this.itens = pedido.getItens();
        this.total = pedido.getTotal();
    }

    public PedidoDto() {
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
