package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.servicos.AtualizarServico;
import org.springframework.stereotype.Component;

@Component
public class SharkFightUC {

    private final AtualizarServico atualizarServico;


    public SharkFightUC(AtualizarServico atualizarServico){
        this.atualizarServico = atualizarServico;
    }

    public StartupDto[] sharkFight(long id){
        return new StartupDto[]{StartupDto.fromModel(this.atualizarServico.atualizarPontos(id))};
    }

}

