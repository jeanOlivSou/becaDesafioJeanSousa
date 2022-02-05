package io.github.jeanolivsou.JSnackbar.services;

import io.github.jeanolivsou.JSnackbar.dtos.responses.LancheResponseDto;
import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import io.github.jeanolivsou.JSnackbar.repositories.LacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class LancheService {

    @Autowired
    private LacheRepository lacheRepository;

    public LancheResponseDto criar(Lanche lanche){

        Lanche lancheSalvo =
                lacheRepository
                        .save(lanche);

        return new LancheResponseDto(lancheSalvo);
    }

    public Lanche atualizar( LancheResponseDto lancheResponseDto, Integer id){

        return lacheRepository
                .findById(id)
                .map(lanche -> {
                    lanche.setNome(lancheResponseDto.getNome());
                    lanche.setDesc(lancheResponseDto.getDesc());
                    lanche.setPrecoUnit(lancheResponseDto.getPrecoUnit());

                    return lacheRepository.save(lanche);

                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletar( Integer id){

        lacheRepository.deleteById(id);

    }

    public List<LancheResponseDto> listar(){

        List<LancheResponseDto> lancheDtoLista = new ArrayList<>();

        lacheRepository.findAll().stream().forEach(
                lanche ->
                        lancheDtoLista
                                .add(new LancheResponseDto(lanche))
        );

        return lancheDtoLista;
    }

    public LancheResponseDto obter(Integer id) {

       Lanche lancheObtido =
               lacheRepository
                       .findById(id)
                       .get();

        return new LancheResponseDto(lancheObtido);
    }
}
