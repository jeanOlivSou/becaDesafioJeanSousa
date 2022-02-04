package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.ClienteDto;
import io.github.jeanolivsou.JSnackbar.entities.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);


    Cliente toEntity(ClienteDto clienteDto);

    @InheritInverseConfiguration
    ClienteDto toDto(Cliente cliente);
}
