package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.BatalhaDto;
import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.servicos.DefinirVencedorServico;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Startup;
import org.springframework.stereotype.Component;

@Component
public class DefinirGanhadorUC {
    private final DefinirVencedorServico definirVencedorServico;

    public DefinirGanhadorUC(DefinirVencedorServico definirVencedorServico) {
        this.definirVencedorServico = definirVencedorServico;
    }

    public StartupDto run(long id){
        System.out.println("Vencedor: "+ this.definirVencedorServico.definirVencedor(id));
        return StartupDto.fromModel(this.definirVencedorServico.definirVencedor(id).getVencedor());
    }
}
