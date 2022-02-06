package io.github.jeanolivsou.JSnackbar.services;



import io.github.jeanolivsou.JSnackbar.dtos.requests.PedidoRequestDto;
import io.github.jeanolivsou.JSnackbar.dtos.responses.PedidoResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import io.github.jeanolivsou.JSnackbar.mappers.PedidoRequestToPedidoMapper;
import io.github.jeanolivsou.JSnackbar.mappers.PedidoToPedidoResponseMapper;
import io.github.jeanolivsou.JSnackbar.mappers.UpdatePedidoMapper;
import io.github.jeanolivsou.JSnackbar.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {


    private final PedidoRepository pedidoRepository;
    private final PedidoRequestToPedidoMapper toPedidoMapper;
    private final PedidoToPedidoResponseMapper toPedidoResponseMapper;
    private final UpdatePedidoMapper updatePedidoMapper;

    public PedidoResponseDto criar(PedidoRequestDto pedidoRequestDto){

        Pedido pedido = toPedidoMapper.toEntity(pedidoRequestDto);

        PedidoResponseDto pedidoResponse = toPedidoResponseMapper.toResponse(pedido);

        pedidoRepository.save(pedido);

        return pedidoResponse;
    }

    public PedidoResponseDto atualizar(PedidoRequestDto pedidoRequestDto, Integer id) {

        Pedido pedido = pedidoRepository.findById(id).get();

        updatePedidoMapper.update(pedidoRequestDto, pedido);

        pedidoRepository.save(pedido);

        return toPedidoResponseMapper.toResponse(pedido);

    }

    public void deletar(Integer id){

        pedidoRepository.deleteById(id);

    }

    public List<PedidoResponseDto> listar(){
        List<PedidoResponseDto> pedidoDtoLista = new ArrayList<>();

        pedidoRepository.findAll().stream().forEach(
                pedido ->
                        pedidoDtoLista
                                .add(toPedidoResponseMapper.toResponse(pedido))
        );

        return pedidoDtoLista;
    }

    public PedidoResponseDto obter(Integer id){

        Pedido pedidoObtido =
                pedidoRepository
                        .findById(id)
                        .get();


        return toPedidoResponseMapper.toResponse(pedidoObtido);

    }
}
