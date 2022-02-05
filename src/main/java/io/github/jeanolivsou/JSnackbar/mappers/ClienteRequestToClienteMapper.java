package io.github.jeanolivsou.JSnackbar.mappers;


import io.github.jeanolivsou.JSnackbar.dtos.requests.ClienteRequestDto;
import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteRequestToClienteMapper {
    public Cliente toEntity(ClienteRequestDto clienteRequestDto);

}
