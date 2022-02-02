package io.github.jeanolivsou.JSnackbar.services;


import io.github.jeanolivsou.JSnackbar.dtos.PedidoDto;
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

    public PedidoDto criar(Pedido pedido){

        Pedido pedidoSalvo =
                pedidoRepository
                        .save(pedido);

        return new PedidoDto(pedidoSalvo);
    }

    public Pedido atualizar(PedidoDto pedidoDto, Integer id) {

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

    public List<PedidoDto> listar(){
        List<PedidoDto> pedidoDtoLista = new ArrayList<>();

        pedidoRepository.findAll().stream().forEach(
                pedido ->
                        pedidoDtoLista
                                .add(new PedidoDto(pedido))
        );

        return pedidoDtoLista;
    }

    public PedidoDto obter(Integer id){

        Pedido pedidoObtido =
                pedidoRepository
                        .findById(id)
                        .get();


        return new PedidoDto(pedidoObtido);

    }
}
