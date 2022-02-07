package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.responses.PedidoResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PedidoToPedidoResponseMapper {

    PedidoToPedidoResponseMapper INSTANCE = Mappers.getMapper(PedidoToPedidoResponseMapper.class);

    public PedidoResponseDto toResponse(Pedido pedido);
}
