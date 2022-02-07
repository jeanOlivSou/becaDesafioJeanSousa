package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.responses.ItemPedidoResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ToItemPedidoResponseMapper {

    ToItemPedidoResponseMapper INSTANCE = Mappers.getMapper(ToItemPedidoResponseMapper.class);

    public ItemPedidoResponseDto toResponse(ItemPedido itemPedido);
}
