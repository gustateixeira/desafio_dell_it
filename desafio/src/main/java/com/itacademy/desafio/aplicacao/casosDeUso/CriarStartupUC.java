package com.itacademy.desafio.aplicacao.casosDeUso;


import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.dominio.servicos.CadastrarServico;
import org.springframework.stereotype.Component;

@Component
public class CriarStartupUC {
    private final CadastrarServico cadastrarServico;


    public CriarStartupUC(CadastrarServico cadastrarServico) {
        this.cadastrarServico = cadastrarServico;
    }

    public StartupDto run(StartupDto st ){
        cadastrarServico.cadastrarStartup(new StartupModel(st.getNome(), st.getSlogan(), st.getFundacao()));
        return st;
    }
}
