package io.github.jeanolivsou.JSnackbar.dtos;

import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancheDto {
    private String nome;
    private String desc;
    private Double precoUnit;


    public LancheDto(Lanche lanche) {
        nome = lanche.getNome();
        desc = lanche.getDesc();
        precoUnit = lanche.getPrecoUnit();
    }

}
