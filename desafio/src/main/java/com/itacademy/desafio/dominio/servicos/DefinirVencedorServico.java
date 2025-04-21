package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.interfaceRepositorios.IBatalhaRepositorio;
import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DefinirVencedorServico {
    private final IBatalhaRepositorio iBatalhaRepositorio;
    private final IStartupRepositorio iStartupRepositorio;
    private final Random random;

    public DefinirVencedorServico(IBatalhaRepositorio iBatalhaRepositorio, IStartupRepositorio iStartupRepositorio, Random r){
        this.iBatalhaRepositorio = iBatalhaRepositorio;
        this.iStartupRepositorio = iStartupRepositorio;
        this.random = r;
    }

    public BatalhaModel definirVencedor(long id){
        BatalhaModel batalhaModel = this.iBatalhaRepositorio.buscarPorId(id);
        StartupModel st1 = batalhaModel.getSt1();
        StartupModel st2 = batalhaModel.getSt2();
        if(st1.getPontuacao() > st2.getPontuacao()){
            batalhaModel.setVencedor(st1);
            iBatalhaRepositorio.atualizar(batalhaModel);
            return batalhaModel;
        }else if(st2.getPontuacao() > st1.getPontuacao()){
            batalhaModel.setVencedor(st2);
            iBatalhaRepositorio.atualizar(batalhaModel);
            return batalhaModel;
        }

        return sharkFight(batalhaModel);
    }

    private BatalhaModel sharkFight(BatalhaModel bt){
        int ganhador = random.nextInt(2);
        if(ganhador == 1){
            bt.setVencedor(bt.getSt1());
            iStartupRepositorio.atualizarPontos(bt.getSt1().getId(), 2);
            return iBatalhaRepositorio.atualizar(bt);
        }
        bt.setVencedor(bt.getSt2());
        iStartupRepositorio.atualizarPontos(bt.getSt2().getId(), 2);
        return iBatalhaRepositorio.atualizar(bt);
    }

}
