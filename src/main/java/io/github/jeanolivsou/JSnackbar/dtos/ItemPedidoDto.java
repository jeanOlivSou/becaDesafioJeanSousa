package io.github.jeanolivsou.JSnackbar.dtos;

import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDto {
    private Integer qtd;
    private Double preco;
    private Lanche lanche;


    public ItemPedidoDto(ItemPedido itemPedido) {
        qtd = itemPedido.getQtd();
        preco = itemPedido.getPreco();
        lanche = itemPedido.getLanche();
    }

}
