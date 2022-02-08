package io.github.jeanolivsou.JSnackbar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lanche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "{campo.not.blank}")
    private String nome;

    @NotBlank(message = "{campo.not.blank}")
    private String desc;

    @Positive(message = "{preco.not.valid}")
    private Double precoUnit;

}
