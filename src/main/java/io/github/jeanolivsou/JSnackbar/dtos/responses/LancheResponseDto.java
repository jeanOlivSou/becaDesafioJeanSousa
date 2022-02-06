package io.github.jeanolivsou.JSnackbar.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancheResponseDto {
    private String nome;
    private String desc;
    private Double precoUnit;
}
