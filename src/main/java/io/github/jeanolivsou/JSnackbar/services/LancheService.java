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

        Lanche lancheSalvo = lacheRepository.save(lanche);

        return lancheSalvo;
    }

    public Lanche atualizar( Lanche lanche, Integer id){
        Lanche lancheObtido = this.obter(id);

        lancheObtido.setNome(lancheObtido.getNome());
        lancheObtido.setDesc(lancheObtido.getDesc());
        lancheObtido.setPrecoUnit(lancheObtido.getPrecoUnit());

        return lanche;
    }

    public void deletar( Integer id){
        lacheRepository.deleteById(id);
    }

    public List<Lanche> listar(){

        List<Lanche> lancheLista = lacheRepository.findAll();

        return lancheLista;
    }

    public Lanche obter(Integer id) {
       Lanche lanche = lacheRepository.findById(id).get();

        return lanche;
    }
}
