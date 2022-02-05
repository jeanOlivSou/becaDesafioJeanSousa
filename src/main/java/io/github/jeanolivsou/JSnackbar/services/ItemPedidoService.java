package io.github.jeanolivsou.JSnackbar.services;


import io.github.jeanolivsou.JSnackbar.dtos.responses.ItemPedidoResponseDto;
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

    public ItemPedidoResponseDto criar(ItemPedido itemPedido){

        return new ItemPedidoResponseDto(itemPedidoRepository.save(itemPedido));
    }

    public ItemPedido atualizar(ItemPedidoResponseDto itemPedidoDto, Integer id) {

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

    public List<ItemPedidoResponseDto> listar(){

        List<ItemPedidoResponseDto> itemPedidoDtoLista = new ArrayList<>();

        itemPedidoRepository.findAll().stream().forEach(
                itemPedido ->
                        itemPedidoDtoLista
                        .add(new ItemPedidoResponseDto(itemPedido))
        );

        return itemPedidoDtoLista;
    }

    public ItemPedidoResponseDto obter(Integer id){

        ItemPedido itemPedidoObtido =
                itemPedidoRepository
                .findById(id)
                .get();

        return new ItemPedidoResponseDto(itemPedidoObtido);
    }
}
