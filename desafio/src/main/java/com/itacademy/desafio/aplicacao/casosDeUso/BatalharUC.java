package com.itacademy.desafio.aplicacao.casosDeUso;


import com.itacademy.desafio.aplicacao.dtos.AvaliacaoDto;
import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.dominio.servicos.AtualizarServico;
import com.itacademy.desafio.dominio.servicos.SelecionarBatalhaServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BatalharUC {
    private final AtualizarServico atualizarServico;
    private final SelecionarBatalhaServico selecionarBatalhaServico;


    public StartupDto run(long id, AvaliacaoDto av){
        StartupModel st = this.selecionarBatalhaServico.selecionarBatalha(id);
        this.atualizarServico.atualizarAvaliacao(id, new AvaliacaoModel(av.getId(), av.getPitch(), av.getBugs(), av.getUsuarios(), av.getInvestidorIrritado(), av.getFakeNews()));
        return StartupDto.fromModel(this.atualizarServico.atualizarPontos(id));
    }
}
