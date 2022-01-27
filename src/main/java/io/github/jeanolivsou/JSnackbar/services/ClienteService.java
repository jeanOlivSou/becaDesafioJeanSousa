package io.github.jeanolivsou.JSnackbar.services;

import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class ClienteService {

    public Cliente criar(Cliente cliente) {
        cliente.setId(2);

        System.out.println(cliente);

        return cliente;

    }

    public Cliente atualizar( Cliente cliente, Integer id){

        cliente.setId(id);

        System.out.println(cliente);

        return cliente;
    }

    public void deletar(Integer id){
        // aqui seu codigo
    }

    public List<Cliente> listar(){

        Cliente c1 = new Cliente(
                1,
                "zé",
                1232115485,
                "jdshfjsdhf",
                846563, "dkhjfdoshfol",
                "kjfgksdjdlk");


        Cliente c2 = new Cliente(
                2,
                "lica",
                1232115485,
                "jdshfjsdhf",
                454682,
                "dkhjfdoshfol",
                "kjfgksdjdlk");


        Cliente c3 = new Cliente(
                3,
                "Doca",
                1232115485,
                "jdshfjsdhf",
                248486331,
                "dkhjfdoshfol",
                "kjfgksdjdlk");

        List<Cliente> clienteLista = Arrays.asList(c1, c2, c3);

        return clienteLista;

    }

    public Cliente obter(Integer id) {
        System.out.println("obteve!" + id);

        Cliente c1 = new Cliente();
        c1.setId(id);
        c1.setNome("zé");
        c1.setEndereco("jdshfjsdhf");
        c1.setCpf(1232115485);
        c1.setTel(846563);
        c1.setSenha("dkhjfdoshfol");
        c1.setEmail("kjfgksdjdlk");

        return c1;

    }
}
