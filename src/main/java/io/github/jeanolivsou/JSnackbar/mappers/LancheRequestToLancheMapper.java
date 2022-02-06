package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.requests.LancheRequestDto;
import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LancheRequestToLancheMapper {

    LancheRequestToLancheMapper INSTANCE = Mappers.getMapper(LancheRequestToLancheMapper.class);

    public Lanche toEntity(LancheRequestDto lancheRequestDto);


}
