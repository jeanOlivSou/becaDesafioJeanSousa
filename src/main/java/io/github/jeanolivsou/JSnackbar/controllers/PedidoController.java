package io.github.jeanolivsou.JSnackbar.controllers;

import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @PostMapping
    public ResponseEntity<Pedido>
    criar(@RequestBody Pedido pedido){

        pedido.setId(2);

        System.out.println(pedido);
        return ResponseEntity.ok(pedido);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pedido>
    atualizar(@RequestBody Pedido pedido, @PathVariable Integer id) {

        pedido.setId(id);

        System.out.println(pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> deletar(@PathVariable Integer id){
       return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listar(){
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

        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obter(@PathVariable Integer id){
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

        return ResponseEntity.ok(p1);

    }



}
