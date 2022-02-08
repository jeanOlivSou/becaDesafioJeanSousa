package io.github.jeanolivsou.JSnackbar.controllers;



import io.github.jeanolivsou.JSnackbar.dtos.requests.PedidoRequestDto;
import io.github.jeanolivsou.JSnackbar.dtos.responses.PedidoResponseDto;
import io.github.jeanolivsou.JSnackbar.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDto>
    criar(@RequestBody @Valid PedidoRequestDto pedidoRequestDto){

        return ResponseEntity
                .created(null)
                .body(pedidoService.criar(pedidoRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PedidoResponseDto>
    atualizar(@RequestBody @Valid PedidoRequestDto pedidoRequestDto, @PathVariable Integer id) {

        return ResponseEntity.ok(
                pedidoService.atualizar(pedidoRequestDto, id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> deletar(@PathVariable Integer id){

        pedidoService.deletar(id);

       return ResponseEntity
               .noContent()
               .build();
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> listar(){

        return ResponseEntity
                .ok(pedidoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> obter(@PathVariable Integer id){

        return ResponseEntity
                .ok(pedidoService.obter(id));

    }



}
