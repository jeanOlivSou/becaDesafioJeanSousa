package io.github.jeanolivsou.JSnackbar.controllers;


import io.github.jeanolivsou.JSnackbar.dtos.PedidoDto;
import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import io.github.jeanolivsou.JSnackbar.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDto>
    criar(@RequestBody Pedido pedido){

        return ResponseEntity
                .created(null)
                .body(pedidoService.criar(pedido));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pedido>
    atualizar(@RequestBody PedidoDto pedidoDto, @PathVariable Integer id) {

        Pedido pedidoAtualizado =
                pedidoService
                        .atualizar(pedidoDto, id);

        return ResponseEntity.ok(pedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> deletar(@PathVariable Integer id){

        pedidoService.deletar(id);

       return ResponseEntity
               .noContent()
               .build();
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> listar(){

        return ResponseEntity
                .ok(pedidoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> obter(@PathVariable Integer id){

        return ResponseEntity
                .ok(pedidoService.obter(id));

    }



}
