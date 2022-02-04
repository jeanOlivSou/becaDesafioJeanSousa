package io.github.jeanolivsou.JSnackbar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    @NotBlank(message = "{campo.not.blank}")
    private Double precoUnit;

}
