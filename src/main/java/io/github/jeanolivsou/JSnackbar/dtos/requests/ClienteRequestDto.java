package io.github.jeanolivsou.JSnackbar.dtos.requests;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ClienteRequestDto {

    private Integer id;

    @NotBlank(message = "{campo.not.blank}")
    @Pattern(regexp = "^[A-Z]+(.)*")
    private String nome;

    @CPF(message = "{cpf.not.valid}")
    @NotBlank(message = "{campo.not.blank}")
    private String cpf;

    @NotBlank(message = "{campo.not.blank}")
    private String endereco;

    @Size(min = 11, max = 11, message = "{tel.size.notvalid}")
    private String tel;

    @Size(min = 8, max = 20, message = "{senha.not.valid}")
    private String senha;

    @Email(message = "{email.not.valid}")
    private String email;


}
