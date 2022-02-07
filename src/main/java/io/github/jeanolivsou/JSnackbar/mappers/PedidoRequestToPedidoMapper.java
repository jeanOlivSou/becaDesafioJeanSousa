package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.requests.PedidoRequestDto;
import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PedidoRequestToPedidoMapper {

    PedidoRequestToPedidoMapper INSTANCE = Mappers.getMapper(PedidoRequestToPedidoMapper.class);

    public Pedido toEntity(PedidoRequestDto pedidoRequestDto);
}