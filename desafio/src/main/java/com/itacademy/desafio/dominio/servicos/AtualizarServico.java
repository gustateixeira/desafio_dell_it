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
        return this.startupRepositorio.atualizarPontos(id);
    }

    public AvaliacaoModel atualizarAvaliacao(long id, AvaliacaoModel av){
        StartupModel st = this.startupRepositorio.buscarPorId(id);
        this.avaliacaoRepositorio.atualizarAvaliacao(st.getAv().getId(), av.getPitch(), av.getBugs(), av.getUsuarios(), av.getInvestidorIrritado(), av.getFakeNews());
        return av;
    }

}

