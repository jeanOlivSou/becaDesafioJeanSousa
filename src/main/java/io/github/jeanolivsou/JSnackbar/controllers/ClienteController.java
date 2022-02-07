package io.github.jeanolivsou.JSnackbar.controllers;



import io.github.jeanolivsou.JSnackbar.dtos.requests.ClienteRequestDto;
import io.github.jeanolivsou.JSnackbar.dtos.responses.ClienteResponseDto;
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


    @PostMapping
    public ResponseEntity<ClienteResponseDto>
    criar(@RequestBody @Valid ClienteRequestDto clienteRequestDto) {

        return ResponseEntity
                .created(null)
                .body(clienteService.criar(clienteRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> atualizar(@RequestBody @Valid ClienteRequestDto clienteRequestDto, @PathVariable Integer id) {

        return ResponseEntity.ok(clienteService.atualizar(clienteRequestDto, id));
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
    public ResponseEntity<List<ClienteResponseDto>> listar(){

        return ResponseEntity
                .ok(clienteService.listar());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> obter(@PathVariable Integer id) {

        return ResponseEntity
                .ok(clienteService.obter(id));

    }

}
