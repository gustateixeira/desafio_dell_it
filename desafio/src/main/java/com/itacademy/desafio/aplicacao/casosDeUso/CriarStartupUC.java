package com.itacademy.desafio.aplicacao.casosDeUso;


import com.itacademy.desafio.aplicacao.dtos.AvaliacaoDto;
import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.dominio.servicos.CadastrarServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CriarStartupUC {
    private final CadastrarServico cadastrarServico;

    public StartupDto run(StartupDto st ){
        StartupModel aux = cadastrarServico.cadastrarStartup(new StartupModel(st.getNome(), st.getSlogan(), st.getFundacao()));
        return new StartupDto(aux.getId(), aux.getNome(), aux.getSlogan(), AvaliacaoDto.fromModel(aux.getAv()) ,aux.getFundacao() ,aux.getPontuacao());
    }
}
