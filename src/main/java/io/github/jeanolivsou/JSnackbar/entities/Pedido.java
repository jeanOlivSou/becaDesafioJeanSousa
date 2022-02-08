package io.github.jeanolivsou.JSnackbar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "{campo.not.blank}")
    private String status;

    @PastOrPresent(message = "{date.not.valid}")
    private Date dataPedido;

    @OneToOne
    private Cliente cliente;

    @OneToMany
    private List<ItemPedido> itens;

    @Positive(message = "{preco.not.valid}")
    private Double total;


}
