package io.github.jeanolivsou.JSnackbar.services;

import io.github.jeanolivsou.JSnackbar.dtos.requests.LancheRequestDto;
import io.github.jeanolivsou.JSnackbar.dtos.responses.LancheResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import io.github.jeanolivsou.JSnackbar.mappers.LancheRequestToLancheMapper;
import io.github.jeanolivsou.JSnackbar.mappers.LancheToLancheResponseMapper;
import io.github.jeanolivsou.JSnackbar.mappers.UpdateLancheMapper;
import io.github.jeanolivsou.JSnackbar.repositories.LacheRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class LancheService {

    private final LacheRepository lancheRepository;
    private final LancheRequestToLancheMapper toLancheMapper;
    private final LancheToLancheResponseMapper toLancheResponseMapper;
    private final UpdateLancheMapper updateLancheMapper;

    public LancheResponseDto criar(LancheRequestDto lancheRequestDto){

        Lanche lanche = toLancheMapper.toEntity(lancheRequestDto);

        LancheResponseDto lancheResponse = toLancheResponseMapper.toResponse(lanche);

        lancheRepository.save(lanche);


        return lancheResponse;
    }

    public LancheResponseDto atualizar( LancheRequestDto lancheRequestDto, Integer id){

        Lanche lanche = lancheRepository.findById(id).get();

        updateLancheMapper.update(lancheRequestDto, lanche);

        lancheRepository.save(lanche);

        return toLancheResponseMapper.toResponse(lanche);
    }

    public void deletar( Integer id){

        lancheRepository.deleteById(id);

    }

    public List<LancheResponseDto> listar(){

        List<LancheResponseDto> lancheDtoLista = new ArrayList<>();

        lancheRepository.findAll().stream().forEach(
                lanche ->
                        lancheDtoLista
                                .add(toLancheResponseMapper.toResponse(lanche))
        );

        return lancheDtoLista;
    }

    public LancheResponseDto obter(Integer id) {

       Lanche lancheObtido =
               lancheRepository
                       .findById(id)
                       .get();

        return toLancheResponseMapper
                .toResponse(lancheObtido);
    }
}
