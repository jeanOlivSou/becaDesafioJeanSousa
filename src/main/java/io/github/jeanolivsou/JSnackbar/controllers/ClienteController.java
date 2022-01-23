package io.github.jeanolivsou.JSnackbar.controllers;


import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PostMapping
    public ResponseEntity<Cliente>
    criar(@RequestBody Cliente cliente) {

        if (cliente.getNome().length() <= 3) {
            return ResponseEntity.unprocessableEntity().build();
        }

        cliente.setId(2);

        System.out.println(cliente);
        return ResponseEntity.created(null).body(cliente);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable Integer id){
        cliente.setId(id);
        System.out.println(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){

        Cliente c1 = new Cliente();
        c1.setId(1);
        c1.setNome("zé");
        c1.setEndereco("jdshfjsdhf");
        c1.setCpf(1232115485);
        c1.setTel(846563);
        c1.setSenha("dkhjfdoshfol");
        c1.setEmail("kjfgksdjdlk");

        Cliente c2 = new Cliente();
        c2.setId(2);
        c2.setNome("lica");
        c2.setEndereco("jdshfjsdhf");
        c2.setCpf(1232115485);
        c2.setTel(846563);
        c2.setSenha("dkhjfdoshfol");
        c2.setEmail("kjfgksdjdlk");

        Cliente c3 = new Cliente();
        c3.setId(3);
        c3.setNome("doca");
        c3.setEndereco("jdshfjsdhf");
        c3.setCpf(1232115485);
        c3.setTel(846563);
        c3.setSenha("dkhjfdoshfol");
        c3.setEmail("kjfgksdjdlk");

        return ResponseEntity.ok(List.of(c1, c2, c3));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obter(@PathVariable Integer id) {
        System.out.println("obteve!" + id);

        Cliente c1 = new Cliente();
        c1.setId(id);
        c1.setNome("zé");
        c1.setEndereco("jdshfjsdhf");
        c1.setCpf(1232115485);
        c1.setTel(846563);
        c1.setSenha("dkhjfdoshfol");
        c1.setEmail("kjfgksdjdlk");

        return ResponseEntity.ok(c1);

    }

}
