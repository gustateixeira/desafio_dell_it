package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.BatalhaDto;
import com.itacademy.desafio.dominio.servicos.SelecionarBatalhaServico;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class SelecionarBatalhaUC {
    private final SelecionarBatalhaServico selecionarBatalhaServico;
    private @Getter @Setter BatalhaDto batalhaEscolhidaId;

    public SelecionarBatalhaUC(SelecionarBatalhaServico selecionarBatalhaServico) {
        this.selecionarBatalhaServico = selecionarBatalhaServico;
    }

    public BatalhaDto selecionarBatalha(long id){
        this.batalhaEscolhidaId = BatalhaDto.fromModel(this.selecionarBatalhaServico.selecionarBatalha(id));
        return batalhaEscolhidaId;
    }
}
