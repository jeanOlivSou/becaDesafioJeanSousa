package io.github.jeanolivsou.JSnackbar.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultException> handle(MethodArgumentNotValidException e){
        DefaultException defaultException = new DefaultException();

        defaultException.setMessage(
                e.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .findFirst()
                        .get()
                        .getDefaultMessage());

        defaultException.setDateTime(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity
                .status(defaultException.getStatus())
                .body(defaultException);

    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<DefaultException> notFound(EmptyResultDataAccessException e){
        DefaultException defaultException = new DefaultException();

        defaultException.setMessage("Registro não encontrado!");
        defaultException.setStatus(HttpStatus.NOT_FOUND.value());
        defaultException.setDateTime(LocalDateTime.now());

        return ResponseEntity
                .status(defaultException.getStatus())
                .body(defaultException);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DefaultException> notFound(NoSuchElementException e){
        DefaultException defaultException = new DefaultException();

        defaultException.setMessage("Registro não encontrado na consulta!");
        defaultException.setStatus(HttpStatus.NOT_FOUND.value());
        defaultException.setDateTime(LocalDateTime.now());

        return ResponseEntity
                .status(defaultException.getStatus())
                .body(defaultException);
    }

    @ExceptionHandler
    public ResponseEntity<DefaultException> jsonError(HttpMessageNotReadableException e){
        DefaultException defaultException = new DefaultException();

        defaultException.setMessage("Erro de sintaxe no JSON!");
        defaultException.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultException.setDateTime(LocalDateTime.now());

        return ResponseEntity
                .status(defaultException.getStatus())
                .body(defaultException);
    }

    


}
