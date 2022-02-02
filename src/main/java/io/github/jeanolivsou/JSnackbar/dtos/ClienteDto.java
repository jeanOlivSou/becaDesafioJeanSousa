package io.github.jeanolivsou.JSnackbar.dtos;

import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import lombok.Data;


@Data
public class ClienteDto {
    private String nome;
    private String endereco;
    private Integer tel;
    private String email;

    public ClienteDto(String nome, String endereco, Integer tel, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.tel = tel;
        this.email = email;
    }

    public ClienteDto(Cliente cliente) {
        nome = cliente.getNome();
        endereco = cliente.getEndereco();
        tel = cliente.getTel();
        email = cliente.getEmail();
    }

    public ClienteDto(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
