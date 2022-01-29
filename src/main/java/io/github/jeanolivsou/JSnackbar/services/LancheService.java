package io.github.jeanolivsou.JSnackbar.services;

import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import io.github.jeanolivsou.JSnackbar.repositories.LacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
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

        lanche.setId(id);

        System.out.println(lanche);

        return lanche;
    }

    public void deletar( Integer id){
        // codigo aqui;
    }

    public List<Lanche> listar(){
        Lanche l1 = new Lanche(
                1,
                "Coxinha",
                "sdkjlksjflkjsdjshf",
                1.50);

        Lanche l2 = new Lanche(
                2,
                "Mini Pizza",
                "lorem ipsum",
                3.50 );

        Lanche l3 = new Lanche(
                3,
                "Pastel",
                "Lorem ipsum",
                2.0);

        List<Lanche> lista = Arrays.asList(l1, l2, l3);

        return lista;
    }

    public Lanche obter(Integer id) {
        Lanche l1 = new Lanche(
                1,
                "Coxinha",
                "sdkjlksjflkjsdjshf",
                1.50);

        return l1;
    }
}
