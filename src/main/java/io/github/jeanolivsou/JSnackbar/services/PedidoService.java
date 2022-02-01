package io.github.jeanolivsou.JSnackbar.services;


import io.github.jeanolivsou.JSnackbar.entities.Pedido;
import io.github.jeanolivsou.JSnackbar.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido criar(Pedido pedido){

        Pedido pedidoSalvo =
                pedidoRepository
                        .save(pedido);


        return pedidoSalvo;
    }

    public Pedido atualizar(Pedido pedido, Integer id) {

        Pedido pedidoAtual = this.obter(id);

        pedidoAtual.setStatus(pedido.getStatus());
        pedidoAtual.setDataPedido(pedido.getDataPedido());
        pedidoAtual.setCliente(pedido.getCliente());
        pedidoAtual.setItens(pedido.getItens());
        pedidoAtual.setTotal(pedido.getTotal());

        pedidoRepository.save(pedidoAtual);


        return pedido;
    }

    public void deletar(Integer id){

        pedidoRepository.deleteById(id);

    }

    public List<Pedido> listar(){
        List<Pedido> pedidoLista =
                pedidoRepository
                        .findAll();

        return pedidoLista;
    }

    public Pedido obter(Integer id){

        Pedido pedidoObtido =
                pedidoRepository
                        .findById(id)
                        .get();


        return pedidoObtido;

    }
}
