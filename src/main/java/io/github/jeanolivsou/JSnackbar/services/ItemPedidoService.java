package io.github.jeanolivsou.JSnackbar.services;

import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.repositories.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedido criar(ItemPedido itemPedido){
        ItemPedido itemPedidoSalvo = itemPedidoRepository.save(itemPedido);

        return itemPedidoSalvo;
    }

    public ItemPedido atualizar(ItemPedido itemPedido, Integer id) {
        ItemPedido itemPedidoObtido = this.obter(id);
        itemPedidoObtido.setQtd(itemPedido.getQtd());
        itemPedidoObtido.setPreco(itemPedido.getPreco());
        itemPedidoObtido.setLanche(itemPedido.getLanche());

        itemPedidoRepository.save(itemPedidoObtido);

        return itemPedido;
    }

    public void deletar(Integer id){
        itemPedidoRepository.deleteById(id);
    }

    public List<ItemPedido> listar(){
        List<ItemPedido> itemPedidoLista =
                itemPedidoRepository.findAll();

        return itemPedidoLista;
    }

    public ItemPedido obter(Integer id){
        ItemPedido itemPedidoObtido =
                itemPedidoRepository
                .findById(id)
                .get();

        return itemPedidoObtido;

    }
}
