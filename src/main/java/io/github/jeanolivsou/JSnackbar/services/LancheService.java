package io.github.jeanolivsou.JSnackbar.services;

import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import io.github.jeanolivsou.JSnackbar.repositories.LacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancheService {

    @Autowired
    private LacheRepository lacheRepository;

    public Lanche criar(Lanche lanche){

        Lanche lancheSalvo =
                lacheRepository
                        .save(lanche);

        return lancheSalvo;
    }

    public Lanche atualizar( Lanche lanche, Integer id){
        Lanche lancheAtual = this.obter(id);

        lancheAtual.setNome(lancheAtual.getNome());
        lancheAtual.setDesc(lancheAtual.getDesc());
        lancheAtual.setPrecoUnit(lancheAtual.getPrecoUnit());

        lacheRepository.save(lancheAtual);

        return lanche;
    }

    public void deletar( Integer id){

        lacheRepository.deleteById(id);

    }

    public List<Lanche> listar(){

        List<Lanche> lancheLista =
                lacheRepository
                        .findAll();

        return lancheLista;
    }

    public Lanche obter(Integer id) {

       Lanche lancheObtido =
               lacheRepository
                       .findById(id)
                       .get();

        return lancheObtido;
    }
}
