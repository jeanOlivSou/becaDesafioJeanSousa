package io.github.jeanolivsou.JSnackbar.controllers;


import io.github.jeanolivsou.JSnackbar.dtos.requests.ItemPedidoRequestDto;
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
    criar(@RequestBody ItemPedidoRequestDto itemPedidoRequestDto){

        return ResponseEntity
                .created(null)
                .body(itemPedidoService.criar(itemPedidoRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDto>
    atualizar(@RequestBody ItemPedidoRequestDto itemPedidoRequestDto, @PathVariable Integer id) {

        return ResponseEntity.ok(
                (itemPedidoService.atualizar(itemPedidoRequestDto, id))
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
    public ResponseEntity<List<ItemPedidoResponseDto>> listar(){

        return ResponseEntity.ok(itemPedidoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDto> obter(@PathVariable Integer id){

        return ResponseEntity
                .ok(itemPedidoService.obter(id));

    }
}
