package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.interfaceRepositorios.IBatalhaRepositorio;
import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import org.hibernate.tool.schema.spi.ScriptTargetOutput;
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
        if(!batalhaModel.isFinalizada()){
            throw new IllegalArgumentException("Essa batalha não foi finalizada ainda.");
        }
        StartupModel st1 = batalhaModel.getSt1();
        StartupModel st2 = batalhaModel.getSt2();
        st1 = this.iStartupRepositorio.atualizarPontos(st1.getId(), 0);
        st2 = this.iStartupRepositorio.atualizarPontos(st2.getId(), 0);
        if(st1.getPontuacao() > st2.getPontuacao()){
            st1 = this.iStartupRepositorio.atualizarPontos(st1.getId(), 30);
            batalhaModel.setVencedor(st1);
            System.out.println("VENCEDOR: " +  st1);
            return iBatalhaRepositorio.atualizar(batalhaModel);
        }else if(st2.getPontuacao() > st1.getPontuacao()){
            st2 = this.iStartupRepositorio.atualizarPontos(st2.getId(), 30);
            batalhaModel.setVencedor(st2);
            System.out.println("VENCEDOR: " +  st2);
            return iBatalhaRepositorio.atualizar(batalhaModel);
        }

        return sharkFight(batalhaModel);
    }

    private BatalhaModel sharkFight(BatalhaModel bt){
        int ganhador = random.nextInt(2);
        System.out.println("ST1: " + bt.getSt1().toString());
        System.out.println("ST2: " + bt.getSt2().toString());
        System.out.println();
        if(ganhador == 1){
            bt.setVencedor(iStartupRepositorio.atualizarPontos(bt.getSt1().getId(), 2));
            iBatalhaRepositorio.atualizar(bt);
            return iBatalhaRepositorio.atualizar(bt);
        }
        bt.setVencedor(iStartupRepositorio.atualizarPontos(bt.getSt2().getId(), 2));
        return iBatalhaRepositorio.atualizar(bt);
    }

}
