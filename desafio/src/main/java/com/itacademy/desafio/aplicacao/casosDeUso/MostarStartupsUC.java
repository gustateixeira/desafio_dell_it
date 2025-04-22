package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.servicos.StartupServico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MostarStartupsUC {
    private final StartupServico startupServico;

    public MostarStartupsUC(StartupServico startupServico) {
        this.startupServico = startupServico;
    }

    public List<StartupDto> run(){
        return this.startupServico.listar().stream().map(StartupDto::fromModel).toList();
    }

}
