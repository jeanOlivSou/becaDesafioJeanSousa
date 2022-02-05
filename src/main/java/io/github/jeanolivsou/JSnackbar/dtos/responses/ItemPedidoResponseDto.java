package io.github.jeanolivsou.JSnackbar.dtos.responses;

import io.github.jeanolivsou.JSnackbar.dtos.requests.LancheRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoResponseDto {
    private Integer id;
    private Integer qtd;
    private Double preco;
    private LancheResponseDto lanche;



}
