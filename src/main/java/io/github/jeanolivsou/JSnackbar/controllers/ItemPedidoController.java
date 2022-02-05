package io.github.jeanolivsou.JSnackbar.controllers;


import io.github.jeanolivsou.JSnackbar.dtos.responses.ItemPedidoResponseDto;
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
    public ResponseEntity<ItemPedidoResponseDto>
    criar(@RequestBody ItemPedido itemPedido){

        return ResponseEntity
                .created(null)
                .body(itemPedidoService.criar(itemPedido));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDto>
    atualizar(@RequestBody ItemPedidoResponseDto itemPedidoResponseDto, @PathVariable Integer id) {

        return ResponseEntity.ok(
                new ItemPedidoResponseDto((itemPedidoService
                        .atualizar(itemPedidoResponseDto, id))
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemPedido> deletar(@PathVariable Integer id){

        itemPedidoService.deletar(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponseDto>> listar(){

        return ResponseEntity.ok(itemPedidoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDto> obter(@PathVariable Integer id){

        return ResponseEntity
                .ok(itemPedidoService.obter(id));

    }
}
