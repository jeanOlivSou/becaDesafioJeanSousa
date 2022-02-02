package io.github.jeanolivsou.JSnackbar.dtos;

import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import lombok.Data;

@Data
public class LancheDto {
    private String nome;
    private String desc;
    private Double precoUnit;

    public LancheDto(String nome, String desc, Double precoUnit) {
        this.nome = nome;
        this.desc = desc;
        this.precoUnit = precoUnit;
    }


    public LancheDto(Lanche lanche) {
        nome = lanche.getNome();
        desc = lanche.getDesc();
        precoUnit = lanche.getPrecoUnit();
    }


    public LancheDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(Double precoUnit) {
        this.precoUnit = precoUnit;
    }
}
