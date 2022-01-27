package io.github.jeanolivsou.JSnackbar.services;

import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PedidoService {

    public Pedido criar(Pedido pedido){

        pedido.setId(2);

        System.out.println(pedido);

        return pedido;
    }

    public Pedido atualizar(Pedido pedido, Integer id) {

        pedido.setId(id);

        System.out.println(pedido);

        return pedido;
    }

    public void deletar(Integer id){
        //codigo aqui
    }

    public List<Pedido> listar(){
        Lanche l1 = new Lanche(1,
                "Coxinha",
                "sdkjlksjflkjsdjshf",
                1.50);

        Lanche l2 = new Lanche(2,
                "Mini Pizza",
                "lorem ipsum",
                3.50 );

        Lanche l3 = new Lanche(3,
                "Pastel",
                "Lorem ipsum",
                2.0);

        Cliente cl1 = new Cliente(1,
                "zeca",
                25415454,
                "fgjdigodijgfoij",
                625151,
                "dfkjgkdfjg",
                "djfdsjf" );

        ItemPedido it1 = new ItemPedido(1, 2, 3.00, l1);
        ItemPedido it2 = new ItemPedido(2, 3, 10.50, l2);


        List itens = Arrays.asList(it1, it2);

        Pedido p1 = new Pedido(1, "Preparando", new Date(), cl1, itens, 3.00);
        Pedido p2 = new Pedido(2, "Preparando", new Date(), cl1, itens, 21.00);

        List pedidos = Arrays.asList(p1, p2);

        return pedidos;
    }

    public Pedido obter(Integer id){
        Lanche l3 = new Lanche(3,
                "Pastel",
                "Lorem ipsum",
                2.0);

        Cliente cl1 = new Cliente(1,
                "zeca",
                25415454,
                "fgjdigodijgfoij",
                625151,
                "dfkjgkdfjg",
                "djfdsjf" );

        ItemPedido it1 = new ItemPedido(1,
                2,
                4.0,
                l3);

        List itens = Arrays.asList(it1);

        Pedido p1 = new Pedido(id,
                "Preparando",
                new Date(),
                cl1,
                itens,
                21.00);

        return p1;

    }
}
