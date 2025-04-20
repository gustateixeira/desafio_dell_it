package com.itacademy.desafio.aplicacao.casosDeUso;


import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.dominio.servicos.CadastrarServico;
import com.itacademy.desafio.dominio.servicos.StartupServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor //o Framework construtor
public class CriarStartupUC {
    private final CadastrarServico cadastrarServico;
    private final StartupServico startupServico;

    public StartupDto run(StartupDto st ){
        StartupModel aux = cadastrarServico.cadastrarStartup(new StartupModel(st.getNome(), st.getSlogan(), st.getFundacao()));
        return new StartupDto(aux.getId(), aux.getNome(), aux.getSlogan(),aux.getAv().getId() ,aux.getFundacao() ,aux.getPontuacao());
    }
}
