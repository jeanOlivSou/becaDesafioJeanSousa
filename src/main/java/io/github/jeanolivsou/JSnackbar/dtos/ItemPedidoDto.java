package io.github.jeanolivsou.JSnackbar.dtos;

import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import lombok.Data;

@Data
public class ItemPedidoDto {
    private Integer qtd;
    private Double preco;
    private Lanche lanche;

    public ItemPedidoDto(Integer qtd, Double preco, Lanche lanche) {
        this.qtd = qtd;
        this.preco = preco;
        this.lanche = lanche;
    }

    public ItemPedidoDto(ItemPedido itemPedido) {
        qtd = itemPedido.getQtd();
        preco = itemPedido.getPreco();
        lanche = itemPedido.getLanche();
    }

    public ItemPedidoDto() {
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
}
