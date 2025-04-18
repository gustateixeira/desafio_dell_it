package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.dominio.servicos.SorteioServico;
import com.itacademy.desafio.dominio.servicos.ValidadorServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class IniciarBatalhaUC {
    private final ValidadorServico validadorServico;

    private final SorteioServico sorteioServico;

    public IniciarBatalhaUC(ValidadorServico validadorServico, SorteioServico sorteioServico) {
        this.validadorServico = validadorServico;
        this.sorteioServico = sorteioServico;
    }

    public Map<StartupModel, StartupModel> run(){
        if(!validadorServico.valida()){
            throw new IllegalArgumentException();
        }
        return sorteioServico.sortear();
    }

}
