package io.github.jeanolivsou.JSnackbar.entities;

import java.util.Objects;

public class ItemPedido {
    private Integer id;
    private Integer qtd;
    private Double preco;
    private Lanche lanche;

    public ItemPedido() {
    }

    public ItemPedido(Integer id, Integer qtd, Double preco, Lanche lanche) {
        this.id = id;
        this.qtd = qtd;
        this.preco = preco;
        this.lanche = lanche;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
