package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.responses.ClienteResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteToClienteResponseMapper {
    public ClienteResponseDto toResponse(Cliente cliente);
}
