package io.github.jeanolivsou.JSnackbar.mappers;

import io.github.jeanolivsou.JSnackbar.dtos.responses.LancheResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LancheToLancheResponseMapper {

    LancheToLancheResponseMapper INSTANCE = Mappers.getMapper(LancheToLancheResponseMapper.class);

    public LancheResponseDto toResponse(Lanche lanche);

}
