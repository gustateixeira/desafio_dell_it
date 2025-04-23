package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.servicos.StartupServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Component
public class MostarStartupsUC {
    private final StartupServico startupServico;

    public List<StartupDto> run(){
        List<StartupDto> startupDtos = new java.util.ArrayList<>(this.startupServico.listar().stream().map(StartupDto::fromModel).toList());
        startupDtos.sort(Comparator.comparingInt(StartupDto::getPontuacao).reversed());
        return startupDtos;
    }

}
