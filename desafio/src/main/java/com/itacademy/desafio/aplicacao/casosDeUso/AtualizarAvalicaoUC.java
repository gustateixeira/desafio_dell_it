package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.dominio.servicos.AtualizarServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AtualizarAvalicaoUC {
    private AtualizarServico atualizarServico;

    public StartupDto run(StartupDto st){
        this.atualizarServico.atualizarAvaliacao(new StartupModel(st.ge));
    }
}
