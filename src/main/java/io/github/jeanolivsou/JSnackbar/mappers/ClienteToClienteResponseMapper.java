package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.responses.ClienteResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteToClienteResponseMapper {

    ClienteToClienteResponseMapper INSTANCE = Mappers.getMapper(ClienteToClienteResponseMapper.class);

    public ClienteResponseDto toResponse(Cliente cliente);
}
