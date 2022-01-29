package io.github.jeanolivsou.JSnackbar.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Status;
    private Date dataPedido;

    @OneToOne
    private Cliente cliente;

    @OneToMany
    private List<ItemPedido> itens;
    private Double total;

    public Pedido() {
    }

    public Pedido(Integer id, String status, Date dataPedido,
                  Cliente cliente, List<ItemPedido> itens, Double total) {
        this.id = id;
        Status = status;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.itens = itens;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id.equals(pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", Status='" + Status + '\'' +
                ", dataPedido=" + dataPedido +
                ", cliente=" + cliente +
                ", itens=" + itens +
                ", total=" + total +
                '}';
    }
}
