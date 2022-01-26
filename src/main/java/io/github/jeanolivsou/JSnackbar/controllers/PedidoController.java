package io.github.jeanolivsou.JSnackbar.controllers;


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
    public ResponseEntity<Pedido>
    criar(@RequestBody Pedido pedido){

        Pedido pedidoCriado = pedidoService.criar(pedido);

        return ResponseEntity.ok(pedidoCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pedido>
    atualizar(@RequestBody Pedido pedido, @PathVariable Integer id) {

        pedidoService.atualizar(pedido, id);

        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> deletar(@PathVariable Integer id){

        pedidoService.deletar(id);

       return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listar(){

        List<Pedido> pedidoListado =
                pedidoService.listar();

        return ResponseEntity.ok(pedidoListado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obter(@PathVariable Integer id){

        Pedido pedidoObtido = pedidoService.obter(id);

        return ResponseEntity.ok(pedidoObtido);

    }



}
