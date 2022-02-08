package io.github.jeanolivsou.JSnackbar.controllers;

import io.github.jeanolivsou.JSnackbar.dtos.requests.LancheRequestDto;
import io.github.jeanolivsou.JSnackbar.dtos.responses.LancheResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import io.github.jeanolivsou.JSnackbar.services.LancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lanche")
public class LancheController {

    @Autowired
    private LancheService lancheService;

    @PostMapping
    public ResponseEntity<LancheResponseDto>
    criar(@RequestBody @Valid LancheRequestDto lancheRequestDto){

        return ResponseEntity
                .created(null)
                .body(lancheService.criar(lancheRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LancheResponseDto>
    atualizar(@RequestBody @Valid LancheRequestDto lancheRequestDto, @PathVariable Integer id){

        return ResponseEntity
                .ok(lancheService.atualizar(lancheRequestDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lanche>
    deletar(@PathVariable Integer id){

        lancheService.deletar(id);

       return ResponseEntity
               .noContent()
               .build();
    }

    @GetMapping
    public ResponseEntity<List<LancheResponseDto>> listar(){

        return ResponseEntity
                .ok(lancheService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LancheResponseDto>
    obter(@PathVariable Integer id) {

        return ResponseEntity
                .ok(lancheService.obter(id));
    }


}
