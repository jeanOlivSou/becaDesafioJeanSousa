package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.requests.LancheRequestDto;
import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UpdateLancheMapper {

    UpdateLancheMapper INSTANCE = Mappers.getMapper(UpdateLancheMapper.class);

    public void update(LancheRequestDto lancheRequestDto, @MappingTarget Lanche lanche);
}
