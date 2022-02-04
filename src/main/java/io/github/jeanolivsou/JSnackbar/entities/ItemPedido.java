package io.github.jeanolivsou.JSnackbar.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer qtd;
    private Double preco;

    @ManyToOne
    private Lanche lanche;

}
