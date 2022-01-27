package io.github.jeanolivsou.JSnackbar.controllers;

import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedido>
    criar(@RequestBody ItemPedido itemPedido){

        ItemPedido itemPedidoCriado =
                itemPedidoService.criar(itemPedido);

        return ResponseEntity
                .created(null)
                .body(itemPedidoCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemPedido>
    atualizar(@RequestBody ItemPedido itemPedido, @PathVariable Integer id) {

        ItemPedido itPedidoAtual = itemPedidoService.atualizar(itemPedido, id);

        return ResponseEntity.ok(itPedidoAtual);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemPedido> deletar(@PathVariable Integer id){

        itemPedidoService.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ItemPedido>>
    listar(){

        List<ItemPedido> itPedidoListado = itemPedidoService.listar();

        return ResponseEntity.ok(itPedidoListado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> obter(@PathVariable Integer id){

        ItemPedido itPedidoObtido = itemPedidoService.obter(id);

        return ResponseEntity.ok(itPedidoObtido);

    }
}
