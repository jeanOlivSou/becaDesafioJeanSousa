package io.github.jeanolivsou.JSnackbar.dtos.requests;


import lombok.Data;

@Data
public class ItemPedidoRequestDto {
    private Integer id;
    private Integer qtd;
    private Double preco;
    private LancheRequestDto lanche;
}
