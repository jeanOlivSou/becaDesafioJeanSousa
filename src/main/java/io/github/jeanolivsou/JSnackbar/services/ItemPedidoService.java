package io.github.jeanolivsou.JSnackbar.services;


import io.github.jeanolivsou.JSnackbar.dtos.requests.ItemPedidoRequestDto;
import io.github.jeanolivsou.JSnackbar.dtos.responses.ItemPedidoResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.mappers.ToItemPedidoMapper;
import io.github.jeanolivsou.JSnackbar.mappers.ToItemPedidoResponseMapper;
import io.github.jeanolivsou.JSnackbar.mappers.UpdateItemPedidoMapper;
import io.github.jeanolivsou.JSnackbar.repositories.ItemPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final ToItemPedidoMapper toItemPedidoMapper;
    private final ToItemPedidoResponseMapper toItemPedidoResponseMapper;
    private final UpdateItemPedidoMapper updateItemPedidoMapper;

    public ItemPedidoResponseDto criar(ItemPedidoRequestDto itemPedidoRequestDto){

        ItemPedido itemPedido =
                toItemPedidoMapper
                        .toEntity(itemPedidoRequestDto);

        ItemPedidoResponseDto itemPedidoResponse =
                toItemPedidoResponseMapper
                        .toResponse(itemPedido);

        itemPedidoRepository.save(itemPedido);

        return itemPedidoResponse;
    }

    public ItemPedidoResponseDto atualizar(ItemPedidoRequestDto itemPedidoRequestDto, Integer id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id).get();

        updateItemPedidoMapper.update(itemPedidoRequestDto, itemPedido);

        ItemPedidoResponseDto itemPedidoResponse =
                toItemPedidoResponseMapper
                        .toResponse(itemPedido);


        itemPedidoRepository.save(itemPedido);

        return itemPedidoResponse;
    }

    public void deletar(Integer id){

        itemPedidoRepository.deleteById(id);

    }

    public List<ItemPedidoResponseDto> listar(){

        List<ItemPedidoResponseDto> itemPedidoDtoLista = new ArrayList<>();

        itemPedidoRepository.findAll().stream().forEach(
                itemPedido ->
                        itemPedidoDtoLista
                        .add(toItemPedidoResponseMapper.toResponse(itemPedido))
        );

        return itemPedidoDtoLista;
    }

    public ItemPedidoResponseDto obter(Integer id){

        ItemPedido itemPedidoObtido =
                itemPedidoRepository
                .findById(id)
                .get();

        return toItemPedidoResponseMapper.toResponse(itemPedidoObtido);
    }
}
