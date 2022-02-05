package io.github.jeanolivsou.JSnackbar.dtos.requests;

import lombok.Data;

@Data
public class ClienteRequestDto {
    private Integer id;
    private String nome;
    private String cpf;
    private String endereco;
    private String tel;
    private String senha;
    private String email;
}
