package com.itacademy.desafio.interfaceAdaptadora.repositorios.implementRepositorios;

import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Avaliacao;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Startup;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.interfacesJpa.StartupRepositorio;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class StartupREPJpa implements IStartupRepositorio {
    private final StartupRepositorio startupRepositorio;


    public StartupREPJpa(StartupRepositorio startupRepositorio) {
        this.startupRepositorio = startupRepositorio;
    }

    public List<StartupModel> buscarTodos(){
        List<Startup> startups = this.startupRepositorio.findAll();
        return startups.stream().
                map(startup -> new StartupModel(startup.getId(),startup.getNome(),
                        Avaliacao.toAvaliacaoModel(startup.getAv()),startup.getSlogan(),
                        startup.getFundacao(),
                        startup.getPontuacao()))
                        .toList();
    }

    public StartupModel add(StartupModel st){
        Startup s = Startup.fromStartupModel(st);
        startupRepositorio.save(s);
        return st;
    }

    public StartupModel buscarPorId(long id){
        return Startup.toStartupModel(startupRepositorio.findById(id));
    }

    public StartupModel atualizarPontos(long id, int novosPontos){
        Startup st = this.startupRepositorio.findById(id);
        st.setPontuacao(novosPontos);
        this.startupRepositorio.save(st);
        return Startup.toStartupModel(st);
    }

}
