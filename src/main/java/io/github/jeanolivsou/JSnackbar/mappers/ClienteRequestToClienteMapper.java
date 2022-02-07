package io.github.jeanolivsou.JSnackbar.mappers;


import io.github.jeanolivsou.JSnackbar.dtos.requests.ClienteRequestDto;
import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteRequestToClienteMapper {

    ClienteRequestToClienteMapper INSTANCE = Mappers.getMapper(ClienteRequestToClienteMapper.class);

    public Cliente toEntity(ClienteRequestDto clienteRequestDto);

}
