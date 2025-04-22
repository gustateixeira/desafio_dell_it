package com.itacademy.desafio.aplicacao.casosDeUso;


import com.itacademy.desafio.aplicacao.dtos.BatalhaDto;
import com.itacademy.desafio.dominio.servicos.AtualizarBatalha;
import com.itacademy.desafio.dominio.servicos.AtualizarServico;
import com.itacademy.desafio.dominio.servicos.ChecarBatalhaServico;
import com.itacademy.desafio.dominio.servicos.StartupServico;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Set;

@Component
public class BatalharUC {
    private final AtualizarServico atualizarServico;
    private final ChecarBatalhaServico checarBatalhaServico;
    private final AtualizarBatalha atualizarBatalha;

    public BatalharUC(AtualizarServico atualizarServico, StartupServico startupServico, Random r, Set<String> eventos, ChecarBatalhaServico checarBatalhaServico, AtualizarBatalha atualizarBatalha) {
        this.atualizarServico = atualizarServico;
        this.checarBatalhaServico = checarBatalhaServico;
        this.atualizarBatalha = atualizarBatalha;
    }
    public BatalhaDto run(String campo, BatalhaDto batalhaDto,  int vl1, int vl2){
        if(batalhaDto.isFinalizada()){
            throw new IllegalArgumentException("Essa batalha já foi finalizada, selecione outra");
        }

        if(checarBatalhaServico.contem(campo)){
            throw new IllegalArgumentException("Este evento já foi avaliado.");
        }

        if(checarBatalhaServico.size() == 5){
            System.out.println("Aqui!");
            this.checarBatalhaServico.add(campo);
            this.atualizarServico.atualizarAvaliacao(batalhaDto.getSt1Id(), vl1, campo);
            this.atualizarServico.atualizarAvaliacao(batalhaDto.getSt2Id(), vl2, campo);
            this.atualizarBatalha.setarFinalizada(batalhaDto.getId());
            batalhaDto.setFinalizada(true);
            this.checarBatalhaServico.restart();
            return batalhaDto;
        }


        this.checarBatalhaServico.add(campo);
        this.atualizarServico.atualizarAvaliacao(batalhaDto.getSt1Id(), vl1, campo);
        this.atualizarServico.atualizarAvaliacao(batalhaDto.getSt2Id(), vl2, campo);

        return batalhaDto;
    }

}

