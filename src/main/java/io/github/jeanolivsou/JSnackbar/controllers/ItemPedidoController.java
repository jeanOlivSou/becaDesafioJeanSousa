package io.github.jeanolivsou.JSnackbar.controllers;

import io.github.jeanolivsou.JSnackbar.dtos.ItemPedidoDto;
import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import io.github.jeanolivsou.JSnackbar.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedidoDto>
    criar(@RequestBody ItemPedido itemPedido){

        return ResponseEntity
                .created(null)
                .body(itemPedidoService.criar(itemPedido));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemPedidoDto>
    atualizar(@RequestBody ItemPedidoDto itemPedidoDto, @PathVariable Integer id) {

        return ResponseEntity.ok(
                new ItemPedidoDto(itemPedidoService
                        .atualizar(itemPedidoDto, id))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemPedido> deletar(@PathVariable Integer id){

        itemPedidoService.deletar(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping
    public ResponseEntity<List<ItemPedidoDto>> listar(){

        return ResponseEntity
                .ok(itemPedidoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDto> obter(@PathVariable Integer id){

        return ResponseEntity
                .ok(itemPedidoService.obter(id));

    }
}
