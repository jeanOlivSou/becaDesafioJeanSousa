package io.github.jeanolivsou.JSnackbar.dtos;

import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    @NotBlank(message = "{nome.not.blank}")
    private String nome;

    @NotBlank(message = "{endereco.not.blank}")
    private String endereco;

    @NotBlank(message = "{tel.not.blank}")
    private String tel;

    @NotBlank(message="{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;

    public ClienteDto(Cliente cliente) {
        nome = cliente.getNome();
        endereco = cliente.getEndereco();
        tel = cliente.getTel();
        email = cliente.getEmail();
    }

}
