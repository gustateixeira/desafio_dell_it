package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.dominio.servicos.StartupServico;
import org.springframework.stereotype.Component;

import javax.swing.plaf.nimbus.State;
import java.util.List;
import java.util.Random;

@Component
public class ModoAleatorioUC {
    private final StartupServico startupServico;
    private final Random r;

    public ModoAleatorioUC(StartupServico startupServico, Random r) {
        this.startupServico = startupServico;
        this.r = r;
    }

    public StartupDto run(){
        List<StartupModel> startups = this.startupServico.listar();
        return StartupDto.fromModel(startups.get(r.nextInt(startups.size())));
    }
}
