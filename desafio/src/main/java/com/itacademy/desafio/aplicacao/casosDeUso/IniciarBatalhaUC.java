package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.dominio.servicos.SorteioServico;
import com.itacademy.desafio.dominio.servicos.ValidadorServico;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class IniciarBatalhaUC {
    private final ValidadorServico validadorServico;

    private final SorteioServico sorteioServico;

    public IniciarBatalhaUC(ValidadorServico validadorServico, SorteioServico sorteioServico) {
        this.validadorServico = validadorServico;
        this.sorteioServico = sorteioServico;
    }

    public Map<StartupDto, StartupDto> run(){
        if(!validadorServico.valida()){
            throw new IllegalArgumentException();
        }
        return sorteioServico.
                sortear().
                entrySet().
                stream().
                collect(Collectors.toMap(entry -> StartupDto.fromModel(entry.getKey()),
                entry -> StartupDto.fromModel(entry.getValue())));
    }


    //TODO: CRIAR UM SERVIÇO QUE LIDA COM A FASE DE BATALHA, CRIAR UM ENDPOINT DE BATALHA
}

