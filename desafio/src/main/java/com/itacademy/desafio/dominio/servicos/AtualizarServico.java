package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IAvaliacaoRepositorio;
import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import org.springframework.stereotype.Service;

@Service
public class AtualizarServico {
    private final IStartupRepositorio startupRepositorio;
    private final IAvaliacaoRepositorio avaliacaoRepositorio;

    public AtualizarServico(IStartupRepositorio startupRepositorio, IAvaliacaoRepositorio avaliacaoRepositorio) {
        this.startupRepositorio = startupRepositorio;
        this.avaliacaoRepositorio = avaliacaoRepositorio;
    }

    public StartupModel atualizarPontos(long id){
        return this.startupRepositorio.atualizarPontos(id,0);
    }

    public void atualizarPontos(long id, int pontos){
        this.startupRepositorio.atualizarPontos(id,pontos);
    }

    public AvaliacaoModel atualizarAvaliacao(long id, int valor, String campo){
        StartupModel st = this.startupRepositorio.buscarPorId(id);
        AvaliacaoModel av = this.avaliacaoRepositorio.atualizarAvaliacao(st.getAv().getId(), valor, campo);
        atualizarPontos(id);
        return av;
    }

}

