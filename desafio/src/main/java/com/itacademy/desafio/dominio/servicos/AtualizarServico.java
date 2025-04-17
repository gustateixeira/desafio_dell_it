package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;

public class AtualizarServico {
    private final IStartupRepositorio startupRepositorio;

    public AtualizarServico(IStartupRepositorio startupRepositorio) {
        this.startupRepositorio = startupRepositorio;
    }

    public StartupModel atualizarPontos(StartupModel st,int novosPontos){
        this.startupRepositorio.atualizarPontos(st.getId(), novosPontos);
        st.setPontuacao(novosPontos);
        return st;
    }
}

