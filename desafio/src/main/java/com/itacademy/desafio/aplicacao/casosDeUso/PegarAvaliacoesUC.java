package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.AvaliacaoDto;
import com.itacademy.desafio.dominio.servicos.AvaliacaoServico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PegarAvaliacoesUC {
    private final AvaliacaoServico avaliacaoServico;

    public PegarAvaliacoesUC(AvaliacaoServico avaliacaoServico) {
        this.avaliacaoServico = avaliacaoServico;
    }
    public List<AvaliacaoDto> run(){
        return this.avaliacaoServico.buscarTodas().stream().map(AvaliacaoDto::fromModel).toList();
    }
}
