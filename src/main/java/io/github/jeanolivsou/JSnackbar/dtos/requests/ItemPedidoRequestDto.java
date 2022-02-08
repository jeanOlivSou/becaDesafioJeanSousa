package io.github.jeanolivsou.JSnackbar.dtos.requests;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Data
public class ItemPedidoRequestDto {
    private Integer id;

    @Min(value = 1, message = "{qtd.not.valid}")
    private Integer qtd;

    @Positive(message = "{preco.not.valid}")
    private Double preco;

    private LancheRequestDto lanche;
}
