package com.itacademy.desafio.aplicacao.casosDeUso;


import com.itacademy.desafio.aplicacao.dtos.AvaliacaoDto;
import com.itacademy.desafio.aplicacao.dtos.BatalhaDto;
import com.itacademy.desafio.dominio.servicos.AtualizarBatalha;
import com.itacademy.desafio.dominio.servicos.AtualizarServico;
import com.itacademy.desafio.dominio.servicos.ChecarBatalhaServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class BatalharUC {
    private final AtualizarServico atualizarServico;
    private final ChecarBatalhaServico checarBatalhaServico;
    private final AtualizarBatalha atualizarBatalha;

    public BatalhaDto run(long id, AvaliacaoDto av1, AvaliacaoDto av2) {
        if (checarBatalhaServico.checarSeFinalizada(id)) {
            throw new IllegalArgumentException("Essa batalha já foi finalizada, selecione outra");
        }
        atualizarServico.atualizarAvaliacao(av1);
        atualizarServico.atualizarAvaliacao(av2);
        return BatalhaDto.fromModel(this.atualizarBatalha.setarFinalizada(id));
    }
}

