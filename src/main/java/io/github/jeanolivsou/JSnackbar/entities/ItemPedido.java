package io.github.jeanolivsou.JSnackbar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Min(value = 1)
    private Integer qtd;

    @Positive(message = "{preco.not.valid}")
    private Double preco;

    @ManyToOne
    private Lanche lanche;

}
