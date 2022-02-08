package io.github.jeanolivsou.JSnackbar.services;



import io.github.jeanolivsou.JSnackbar.dtos.requests.ClienteRequestDto;
import io.github.jeanolivsou.JSnackbar.dtos.responses.ClienteResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import io.github.jeanolivsou.JSnackbar.mappers.ClienteRequestToClienteMapper;
import io.github.jeanolivsou.JSnackbar.mappers.ClienteToClienteResponseMapper;
import io.github.jeanolivsou.JSnackbar.mappers.UpdateClienteMapper;
import io.github.jeanolivsou.JSnackbar.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {


    private final ClienteRepository clienteRepository;
    private final ClienteRequestToClienteMapper toClienteMapper;
    private final ClienteToClienteResponseMapper toClienteResponseMapper;
    private final UpdateClienteMapper updateClienteMapper;

    public ClienteResponseDto criar(ClienteRequestDto clienteRequestDto) {

        Cliente cliente =
                toClienteMapper
                        .toEntity(clienteRequestDto);

        ClienteResponseDto clienteResponse =
                toClienteResponseMapper
                        .toResponse(cliente);

        clienteRepository.save(cliente);

        return clienteResponse;

    }

    public ClienteResponseDto atualizar(ClienteRequestDto clienteRequestDto, Integer id){

        Cliente cliente =
                clienteRepository
                        .findById(id)
                        .get();

        updateClienteMapper.update(clienteRequestDto, cliente);

        clienteRepository.save(cliente);

        return toClienteResponseMapper.toResponse(cliente);
    }

    public void deletar(Integer id){

        clienteRepository.deleteById(id);

    }

    public List<ClienteResponseDto> listar(){

        List<ClienteResponseDto> clienteDtoLista = new ArrayList<>();

        clienteRepository.findAll().stream().forEach(
                cliente ->
                        clienteDtoLista
                                .add(toClienteResponseMapper.toResponse(cliente))
        );


        return clienteDtoLista;

    }

    public ClienteResponseDto obter(Integer id) {

        Cliente clienteObtido =
                clienteRepository
                        .findById(id)
                        .get();

        return toClienteResponseMapper.toResponse(clienteObtido);

    }
}
