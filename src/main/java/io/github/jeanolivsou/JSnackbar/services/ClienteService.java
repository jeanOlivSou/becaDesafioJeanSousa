package io.github.jeanolivsou.JSnackbar.services;

import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import io.github.jeanolivsou.JSnackbar.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar(Cliente cliente) {

        Cliente clienteSalvo = clienteRepository.save(cliente);

        return clienteSalvo;

    }

    public Cliente atualizar( Cliente cliente, Integer id){
        Cliente clienteObtido = this.obter(id);
        clienteObtido.setNome(cliente.getNome());
        clienteObtido.setCpf(cliente.getCpf());
        clienteObtido.setTel(cliente.getTel());
        clienteObtido.setEndereco(cliente.getEndereco());
        clienteObtido.setSenha(cliente.getSenha());
        clienteObtido.setEmail(cliente.getEmail());

        clienteRepository.save(clienteObtido);

        return cliente;
    }

    public void deletar(Integer id){
        clienteRepository.deleteById(id);
    }

    public List<Cliente> listar(){

        List<Cliente> clienteLista = clienteRepository.findAll();

        return clienteLista;

    }

    public Cliente obter(Integer id) {
        Cliente cliente = clienteRepository.findById(id).get();

        return cliente;

    }
}
