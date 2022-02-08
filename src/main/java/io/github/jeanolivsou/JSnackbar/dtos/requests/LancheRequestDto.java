package io.github.jeanolivsou.JSnackbar.dtos.requests;

import lombok.Data;

@Data
public class LancheRequestDto {
    private Integer id;
    private String nome;
    private String desc;
    private Double precoUnit;
}
