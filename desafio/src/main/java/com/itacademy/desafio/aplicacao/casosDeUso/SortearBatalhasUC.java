package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.BatalhaDto;
import com.itacademy.desafio.dominio.servicos.SorteioServico;
import com.itacademy.desafio.dominio.servicos.ValidadorServico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SortearBatalhasUC {
    private final ValidadorServico validadorServico;

    private final SorteioServico sorteioServico;

    public SortearBatalhasUC(ValidadorServico validadorServico, SorteioServico sorteioServico) {
        this.validadorServico = validadorServico;
        this.sorteioServico = sorteioServico;
    }

    public List<BatalhaDto> run(){
        if(!validadorServico.valida()){
            throw new IllegalArgumentException();
        }
        return sorteioServico.sortear().stream().map(bt -> BatalhaDto.fromModel(bt)).toList();
    }


    //TODO: CRIAR UM SERVIÇO QUE LIDA COM A FASE DE BATALHA, CRIAR UM ENDPOINT DE BATALHA
}

