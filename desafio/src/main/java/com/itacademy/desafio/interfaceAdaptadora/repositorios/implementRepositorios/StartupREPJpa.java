package com.itacademy.desafio.interfaceAdaptadora.repositorios.implementRepositorios;

import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Avaliacao;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Startup;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.interfacesJpa.StartupRepositorio;
import org.hibernate.sql.ast.tree.expression.Star;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@Primary
public class StartupREPJpa implements IStartupRepositorio {
    private final StartupRepositorio startupRepositorio;
    private static long id;

    public StartupREPJpa(StartupRepositorio startupRepositorio) {
        this.startupRepositorio = startupRepositorio;
        id = 0;
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
        return Startup.toStartupModel(startupRepositorio.save(s));
    }

    public StartupModel buscarPorId(long id){
        return Startup.toStartupModel(startupRepositorio.findById(id));
    }

    public StartupModel atualizarPontos(long id){
        Startup st = this.startupRepositorio.findById(id);
        int [] av = st.getAv().getAtributos();
        int pontos = st.getPontuacao() + Arrays.stream(av).sum();
        st.setPontuacao(pontos);
        this.startupRepositorio.save(st);
        return Startup.toStartupModel(st);
    }

}
