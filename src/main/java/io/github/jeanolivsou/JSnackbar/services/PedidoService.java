package io.github.jeanolivsou.JSnackbar.services;



import io.github.jeanolivsou.JSnackbar.dtos.responses.PedidoResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import io.github.jeanolivsou.JSnackbar.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public PedidoResponseDto criar(Pedido pedido){

        Pedido pedidoSalvo =
                pedidoRepository
                        .save(pedido);

        return new PedidoResponseDto(pedidoSalvo);
    }

    public Pedido atualizar(PedidoResponseDto pedidoDto, Integer id) {

        return pedidoRepository
                .findById(id)
                .map(pedido -> {
                    pedido.setStatus(pedidoDto.getStatus());
                    pedido.setDataPedido(pedidoDto.getDataPedido());
                    pedido.setCliente(pedidoDto.getCliente());
                    pedido.setItens(pedidoDto.getItens());

                    return pedidoRepository.save(pedido);
                })
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND));
    }

    public void deletar(Integer id){

        pedidoRepository.deleteById(id);

    }

    public List<PedidoResponseDto> listar(){
        List<PedidoResponseDto> pedidoDtoLista = new ArrayList<>();

        pedidoRepository.findAll().stream().forEach(
                pedido ->
                        pedidoDtoLista
                                .add(new PedidoResponseDto(pedido))
        );

        return pedidoDtoLista;
    }

    public PedidoResponseDto obter(Integer id){

        Pedido pedidoObtido =
                pedidoRepository
                        .findById(id)
                        .get();


        return new PedidoResponseDto(pedidoObtido);

    }
}
