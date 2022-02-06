package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.requests.ClienteRequestDto;
import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UpdateClienteMapper {

    UpdateClienteMapper INSTANCE = Mappers.getMapper(UpdateClienteMapper.class);

    public void update(ClienteRequestDto clienteRequestDto, @MappingTarget Cliente cliente);
}
