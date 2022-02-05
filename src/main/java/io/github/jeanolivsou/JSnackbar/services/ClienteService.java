package io.github.jeanolivsou.JSnackbar.services;



import io.github.jeanolivsou.JSnackbar.dtos.requests.ClienteRequestDto;
import io.github.jeanolivsou.JSnackbar.dtos.responses.ClienteResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import io.github.jeanolivsou.JSnackbar.mappers.ClienteRequestToClienteMapper;
import io.github.jeanolivsou.JSnackbar.mappers.ClienteToClienteResponseMapper;
import io.github.jeanolivsou.JSnackbar.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    ClienteRequestToClienteMapper toClienteMapper;

    @Autowired
    ClienteToClienteResponseMapper toClienteResponseMapper;

    public ClienteResponseDto criar(ClienteRequestDto clienteRequestDto) {

        Cliente cliente = toClienteMapper.toEntity(clienteRequestDto);

        ClienteResponseDto clienteResponse = toClienteResponseMapper.toResponse(cliente);

        clienteRepository.save(cliente);

        return clienteResponse;

    }

    public ClienteResponseDto atualizar(ClienteRequestDto clienteRequestDto, Integer id){

        Cliente clienteObtido = clienteRepository
                .findById(id)
                .get();

        clienteResponseDto = clienteMapper.toDto(clienteObtido);

        return clienteRepository
                .save(clienteMapper.toEntity(clienteResponseDto));
    }

    public void deletar(Integer id){

        clienteRepository.deleteById(id);

    }

    public List<ClienteResponseDto> listar(){

        List<ClienteResponseDto> clienteDtoLista = new ArrayList<>();

        clienteRepository.findAll().stream().forEach(
                cliente ->
                        clienteDtoLista
                                .add(clienteMapper.toDto(cliente))
        );


        return clienteDtoLista;

    }

    public ClienteResponseDto obter(Integer id) {

        Cliente clienteObtido =
                clienteRepository
                        .findById(id)
                        .get();

        return clienteMapper.toDto(clienteObtido);

    }
}
