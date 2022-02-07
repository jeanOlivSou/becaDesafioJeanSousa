package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.requests.ItemPedidoRequestDto;
import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ToItemPedidoMapper {

    ToItemPedidoMapper INSTANCE = Mappers.getMapper(ToItemPedidoMapper.class);

    public ItemPedido toEntity(ItemPedidoRequestDto itemPedidoRequestDto);
}
