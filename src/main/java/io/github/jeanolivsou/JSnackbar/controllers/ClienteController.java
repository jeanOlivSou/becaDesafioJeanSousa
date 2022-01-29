package io.github.jeanolivsou.JSnackbar.controllers;


import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import io.github.jeanolivsou.JSnackbar.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente>  criar(@RequestBody Cliente cliente) {

        Cliente clienteCriado = clienteService.criar(cliente);

        return ResponseEntity.created(null).body(clienteCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente>
    atualizar(@RequestBody Cliente cliente, @PathVariable Integer id) {

        Cliente clienteAtualizado =
                clienteService.atualizar(cliente, id);

        return ResponseEntity
                .ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        clienteService.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> clienteLista =
                clienteService.listar();

        return ResponseEntity.ok(clienteLista);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obter(@PathVariable Integer id) {
        Cliente clienteObtido = clienteService.obter(id);
        return ResponseEntity.ok(clienteObtido);

    }

}
