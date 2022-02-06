package io.github.jeanolivsou.JSnackbar.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoResponseDto {
    private Integer qtd;
    private Double preco;
    private LancheResponseDto lanche;

}
