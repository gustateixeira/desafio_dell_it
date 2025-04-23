package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.servicos.DefinirVencedorServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DefinirGanhadorUC {
    private final DefinirVencedorServico definirVencedorServico;



    public StartupDto run(long id){
        return StartupDto.fromModel(this.definirVencedorServico.definirVencedor(id).getVencedor());
    }
}
