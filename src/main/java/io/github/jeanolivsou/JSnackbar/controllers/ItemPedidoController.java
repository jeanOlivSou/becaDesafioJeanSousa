package io.github.jeanolivsou.JSnackbar.controllers;

import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {

    @PostMapping
    public ResponseEntity<ItemPedido>
    criar(@RequestBody ItemPedido itemPedido){
        itemPedido.setId(3);
        System.out.println(itemPedido);
        return ResponseEntity.created(null).body(itemPedido);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemPedido>
    atualizar(@RequestBody ItemPedido itemPedido, @PathVariable Integer id) {
        itemPedido.setId(id);
        System.out.println(itemPedido);
        return ResponseEntity.ok(itemPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemPedido>
    deletar(@PathVariable Integer id){
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ItemPedido>>
    listar(){
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

        return ResponseEntity.ok(itens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> obter(@PathVariable Integer id){
        Lanche l1 = new Lanche(1,
                "Coxinha",
                "sdkjlksjflkjsdjshf",
                1.50);
        ItemPedido it1 = new ItemPedido(1,
                2,
                3.00,
                l1);

        return ResponseEntity.ok(it1);

    }
}
