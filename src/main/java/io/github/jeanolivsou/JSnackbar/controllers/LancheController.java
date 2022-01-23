package io.github.jeanolivsou.JSnackbar.controllers;

import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/lanche")
public class LancheController {

    @PostMapping
    public ResponseEntity<Lanche>
    criar(@RequestBody Lanche lanche){
        lanche.setId(2);
        System.out.println(lanche);
        return ResponseEntity.created(null).body(lanche);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Lanche> atualizar(@RequestBody Lanche lanche, @PathVariable Integer id){
        lanche.setId(id);
        System.out.println(lanche);
        return ResponseEntity.ok(lanche);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lanche>
    deletar(@PathVariable Integer id){
       return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Lanche>> listar(){
        Lanche l1 = new Lanche(1,
                "Coxinha",
                "sdkjlksjflkjsdjshf",
                1.50);

        Lanche l2 = new Lanche(2,
                "Mini Pizza",
                "lorem ipsum",
                3.50 );

        Lanche l3 = new Lanche(3,
                "Pastel",
                "Lorem ipsum",
                2.0);

        var lista = Arrays.asList(l1, l2, l3);

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lanche> obter(@PathVariable Integer id) {
        Lanche l1 = new Lanche(1,
                "Coxinha",
                "sdkjlksjflkjsdjshf",
                1.50);

        return ResponseEntity.ok(l1);
    }


}
