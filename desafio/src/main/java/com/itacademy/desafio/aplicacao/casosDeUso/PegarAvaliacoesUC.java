package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.AvaliacaoDto;
import com.itacademy.desafio.dominio.servicos.AvaliacaoServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PegarAvaliacoesUC {
    private final AvaliacaoServico avaliacaoServico;

    public List<AvaliacaoDto> run(){
        return this.avaliacaoServico.buscarTodas().stream().map(AvaliacaoDto::fromModel).toList();
    }
}
