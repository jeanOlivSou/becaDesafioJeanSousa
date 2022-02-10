package io.github.jeanolivsou.JSnackbar.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoRequestDto {
    private Integer id;

    @NotBlank(message = "{campo.not.blank}")
    private String status;

    @PastOrPresent(message = "{date.not.valid}")
    private LocalDateTime dataPedido = LocalDateTime.now();


    private ClienteRequestDto cliente;
    private List<ItemPedidoRequestDto> itens;

    @Positive(message = "{preco.not.valid}")
    private Double total;
}
