package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.AvaliacaoDto;
import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;
import com.itacademy.desafio.dominio.servicos.AtualizarServico;
import com.itacademy.desafio.dominio.servicos.StartupServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DefinirPontuacaoUC {
    private final AtualizarServico atualizarServico;
    private final StartupServico startupServico;

}
