package io.github.jeanolivsou.JSnackbar.controllers;


import io.github.jeanolivsou.JSnackbar.dtos.ClienteDto;
import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import io.github.jeanolivsou.JSnackbar.mappers.ClienteMapper;
import io.github.jeanolivsou.JSnackbar.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper clienteMapper;

    @PostMapping
    public ResponseEntity<ClienteDto>
    criar(@RequestBody @Valid Cliente cliente) {

        return ResponseEntity
                .created(null)
                .body(clienteService.criar(cliente));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteDto>
    atualizar(@RequestBody @Valid ClienteDto clienteDto, @PathVariable Integer id) {
        return ResponseEntity.ok(
                clienteMapper
                        .toDto(clienteService.atualizar(clienteDto, id))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>
    deletar(@PathVariable Integer id){

        clienteService.deletar(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listar(){

        return ResponseEntity
                .ok(clienteService.listar());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> obter(@PathVariable Integer id) {

        return ResponseEntity
                .ok(clienteService.obter(id));

    }

}
