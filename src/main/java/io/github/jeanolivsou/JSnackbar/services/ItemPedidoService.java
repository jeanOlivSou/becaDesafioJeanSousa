package io.github.jeanolivsou.JSnackbar.services;

import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class ItemPedidoService {


    public ItemPedido criar(ItemPedido itemPedido){

        itemPedido.setId(3);

        System.out.println(itemPedido);

        return itemPedido;
    }

    public ItemPedido atualizar(ItemPedido itemPedido, Integer id) {

        itemPedido.setId(id);

        System.out.println(itemPedido);

        return itemPedido;
    }

    public void deletar(Integer id){
        // codigo aqui
    }

    public List<ItemPedido> listar(){
        Lanche l1 = new Lanche(1,
                "Coxinha",
                "sdkjlksjflkjsdjshf",
                1.50);

        Lanche l2 = new Lanche(2,
                "Mini Pizza",
                "lorem ipsum",
                3.50 );


        ItemPedido it1 = new ItemPedido(1,
                2,
                3.00,
                l1);
        ItemPedido it2 = new ItemPedido(2,
                3,
                10.50,
                l2);

        List itens = Arrays.asList(it1, it2);

        return itens;
    }

    public ItemPedido obter(Integer id){
        Lanche l1 = new Lanche(1,
                "Coxinha",
                "sdkjlksjflkjsdjshf",
                1.50);
        ItemPedido it1 = new ItemPedido(1,
                2,
                3.00,
                l1);

        return it1;

    }
}
