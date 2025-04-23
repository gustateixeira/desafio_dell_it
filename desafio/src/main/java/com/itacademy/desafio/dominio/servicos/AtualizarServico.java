package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.aplicacao.dtos.AvaliacaoDto;
import com.itacademy.desafio.dominio.interfaceRepositorios.IAvaliacaoRepositorio;
import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AtualizarServico {
    private final IAvaliacaoRepositorio avaliacaoRepositorio;


    public AvaliacaoModel atualizarAvaliacao(AvaliacaoDto avaliacaoDto){
        return this.avaliacaoRepositorio.atualizarAvaliacao(avaliacaoDto.getId(), new AvaliacaoModel(avaliacaoDto.getId(),
                avaliacaoDto.getPitch(),
                avaliacaoDto.getBugs(),
                avaliacaoDto.getUsuarios(),
                avaliacaoDto.getInvestidorIrritado(),
                avaliacaoDto.getFakeNews()));
    }

}

