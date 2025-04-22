package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.aplicacao.dtos.AvaliacaoDto;
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

    public AvaliacaoModel atualizarAvaliacao(AvaliacaoDto avaliacaoDto){
        return this.avaliacaoRepositorio.atualizarAvaliacao(avaliacaoDto.getId(), new AvaliacaoModel(avaliacaoDto.getId(),
                avaliacaoDto.getPitch(),
                avaliacaoDto.getBugs(),
                avaliacaoDto.getUsuarios(),
                avaliacaoDto.getInvestidorIrritado(),
                avaliacaoDto.getFakeNews()));
    }

}

