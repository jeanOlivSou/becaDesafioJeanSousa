package io.github.jeanolivsou.JSnackbar.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class LancheRequestDto {

    private Integer id;

    @NotBlank(message = "{campo.not.blank}")
    private String nome;

    @NotBlank(message = "{campo.not.blank}")
    private String descricao;

    @Positive(message = "{preco.not.valid}")
    private Double precoUnit;
}
