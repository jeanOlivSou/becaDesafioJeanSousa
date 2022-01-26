package io.github.jeanolivsou.JSnackbar.controllers;

import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import io.github.jeanolivsou.JSnackbar.services.LancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/lanche")
public class LancheController {

    @Autowired
    LancheService lancheService;

    @PostMapping
    public ResponseEntity<Lanche>
    criar(@RequestBody Lanche lanche){

        Lanche lancheCriado =
                lancheService.criar(lanche);

        return ResponseEntity.created(null).body(lancheCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Lanche>
    atualizar(@RequestBody Lanche lanche, @PathVariable Integer id){
        Lanche lancheCriado = lancheService.atualizar(lanche, id);
        return ResponseEntity.ok(lancheCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lanche>
    deletar(@PathVariable Integer id){

        lancheService.deletar(id);

       return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Lanche>> listar(){

        List<Lanche> lancheCriado =
                lancheService.listar();

        return ResponseEntity.ok(lancheCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lanche> obter(@PathVariable Integer id) {

        Lanche lancheObtido = lancheService.obter(id);

        return ResponseEntity.ok(lancheObtido);
    }


}
