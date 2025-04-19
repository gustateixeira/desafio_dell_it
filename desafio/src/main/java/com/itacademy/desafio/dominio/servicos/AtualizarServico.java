package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IAvaliacaoRepositorio;
import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;
import com.itacademy.desafio.dominio.modelos.StartupModel;

public class AtualizarServico {
    private final IStartupRepositorio startupRepositorio;
    private final IAvaliacaoRepositorio avaliacaoRepositorio;

    public AtualizarServico(IStartupRepositorio startupRepositorio, IAvaliacaoRepositorio avaliacaoRepositorio) {
        this.startupRepositorio = startupRepositorio;
        this.avaliacaoRepositorio = avaliacaoRepositorio;
    }

    public StartupModel atualizarPontos(StartupModel st,int novosPontos){
        this.startupRepositorio.atualizarPontos(st.getId(), novosPontos);
        st.setPontuacao(novosPontos);
        return st;
    }

    public AvaliacaoModel atualizarAvaliacao(StartupModel st, AvaliacaoModel av){
        this.avaliacaoRepositorio.atualizarAvaliacao(st.getAv().getId(), av.getPitch(), av.getBugs(), av.getUsuarios(), av.getInvestidorIrritado(), av.getFakeNews());
        return av;
    }

}

