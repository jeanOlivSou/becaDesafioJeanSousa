package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.requests.ItemPedidoRequestDto;
import io.github.jeanolivsou.JSnackbar.entities.ItemPedido;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UpdateItemPedidoMapper {

    UpdateItemPedidoMapper INSTANCE = Mappers.getMapper(UpdateItemPedidoMapper.class);

    public void update(ItemPedidoRequestDto itemPedidoRequestDto, @MappingTarget ItemPedido itemPedido);

}
