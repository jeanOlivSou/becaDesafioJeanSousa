package io.github.jeanolivsou.JSnackbar.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    @NotBlank(message = "{nome.not.blank}")
    @Pattern(regexp = "^[A-Z]+(.)*")
    private String nome;

    @NotBlank(message = "{endereco.not.blank}")
    private String endereco;

    @Size(max = 11)
    @NotBlank(message = "{tel.not.blank}")
    private String tel;

    @NotBlank(message="{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;

}
