package io.github.jeanolivsou.JSnackbar.controllers;


import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PostMapping
    public void criar(Cliente cliente){
        System.out.println("criou");
    }

    @PatchMapping("/{id}")
    public void atualizar(@RequestBody Cliente cliente,
                          @PathVariable Integer id){
        System.out.println("atualizou" + id);
    }

    @DeleteMapping
    public void deletar(){
        System.out.println("deletou");
    }

    @GetMapping
    public void listar(){
        System.out.println("listou");
    }

    @GetMapping("/{id}")
    public void obter(@PathVariable Integer id) {
        System.out.println("obteve!" + id);

    }

}
