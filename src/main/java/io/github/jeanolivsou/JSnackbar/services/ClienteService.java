package io.github.jeanolivsou.JSnackbar.services;


import io.github.jeanolivsou.JSnackbar.dtos.ClienteDto;
import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import io.github.jeanolivsou.JSnackbar.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDto criar(Cliente cliente) {

        Cliente clienteSalvo =
                clienteRepository
                        .save(cliente);

        return new ClienteDto(clienteSalvo);

    }

    public Cliente atualizar( ClienteDto clienteDto, Integer id){

        return clienteRepository.findById(id)
                .map(cliente -> clienteRepository.save(cliente))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public void deletar(Integer id){

        clienteRepository.deleteById(id);

    }

    public List<ClienteDto> listar(){

        List<ClienteDto> clienteDtoLista = new ArrayList<>();

        clienteRepository.findAll().stream().forEach(
                cliente ->
                        clienteDtoLista
                                .add(new ClienteDto(cliente))
        );


        return clienteDtoLista;

    }

    public ClienteDto obter(Integer id) {

        Cliente clienteObtido =
                clienteRepository
                        .findById(id)
                        .get();

        ClienteDto cliente = new ClienteDto(clienteObtido);

        return cliente;

    }
}
