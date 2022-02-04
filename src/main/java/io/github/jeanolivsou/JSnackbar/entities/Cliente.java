package io.github.jeanolivsou.JSnackbar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "{campo.not.blank}")
    @Pattern(regexp = "^[A-Z]+(.)*")
    private String nome;

    @CPF
    @NotBlank(message = "{campo.not.blank}")
    private String cpf;

    @NotBlank(message = "{campo.not.blank}")
    private String endereco;

    @Size(max = 11)
    @NotBlank(message = "{campo.not.blank}")
    private String tel;

    @Size(min = 8, max = 20, message = "{senha.not.valid}")
    private String senha;

    @Email(message = "{email.not.valid}")
    @NotBlank(message = "{email.not.blank}")
    private String email;


}
