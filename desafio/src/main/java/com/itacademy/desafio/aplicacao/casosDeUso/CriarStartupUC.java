package com.itacademy.desafio.aplicacao.casosDeUso;


import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.dominio.servicos.CadastrarServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor //o Framework construtor
public class CriarStartupUC {
    private final CadastrarServico cadastrarServico;

    public StartupDto run(StartupDto st ){
        cadastrarServico.cadastrarStartup(new StartupModel(st.getNome(), st.getSlogan(), st.getFundacao()));
        return st;
    }
}
