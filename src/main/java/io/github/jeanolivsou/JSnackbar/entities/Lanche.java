package io.github.jeanolivsou.JSnackbar.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Data
@Entity
public class Lanche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String desc;
    private Double precoUnit;

    public Lanche(){}

    public Lanche(Integer id, String nome,
                  String desc, Double precoUnit) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.precoUnit = precoUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lanche lanche = (Lanche) o;
        return id.equals(lanche.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Lanche{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", desc='" + desc + '\'' +
                ", precoUnit=" + precoUnit +
                '}';
    }
}
