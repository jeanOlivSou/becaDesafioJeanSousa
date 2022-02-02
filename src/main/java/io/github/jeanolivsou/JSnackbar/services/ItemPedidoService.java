package io.github.jeanolivsou.JSnackbar.services;

import io.github.jeanolivsou.JSnackbar.dtos.ItemPedidoDto;
import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.repositories.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoDto criar(ItemPedido itemPedido){

        return new ItemPedidoDto(
                itemPedidoRepository
                        .save(itemPedido));
    }

    public ItemPedido atualizar(ItemPedidoDto itemPedidoDto, Integer id) {

        return itemPedidoRepository
                .findById(id)
                .map(itemPedido -> {
                    itemPedido.setQtd(itemPedidoDto.getQtd());
                    itemPedido.setPreco(itemPedidoDto.getPreco());
                    itemPedido.setLanche(itemPedidoDto.getLanche());

                    return itemPedidoRepository.save(itemPedido);
                })
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND));
    }

    public void deletar(Integer id){

        itemPedidoRepository.deleteById(id);

    }

    public List<ItemPedidoDto> listar(){

        List<ItemPedidoDto> itemPedidoDtoLista = new ArrayList<>();

        itemPedidoRepository.findAll().stream().forEach(
                itemPedido ->
                        itemPedidoDtoLista
                        .add(new ItemPedidoDto(itemPedido))
        );

        return itemPedidoDtoLista;
    }

    public ItemPedidoDto obter(Integer id){

        ItemPedido itemPedidoObtido =
                itemPedidoRepository
                .findById(id)
                .get();

        return new ItemPedidoDto(itemPedidoObtido);
    }
}
