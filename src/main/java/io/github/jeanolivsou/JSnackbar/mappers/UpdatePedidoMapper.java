package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.requests.PedidoRequestDto;
import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UpdatePedidoMapper {

    UpdatePedidoMapper INSTANCE = Mappers.getMapper(UpdatePedidoMapper.class);

    public void update(PedidoRequestDto pedidoRequestDto, @MappingTarget Pedido pedido);
}
