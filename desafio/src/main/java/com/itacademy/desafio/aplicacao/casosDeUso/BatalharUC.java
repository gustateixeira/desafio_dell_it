package com.itacademy.desafio.aplicacao.casosDeUso;


import com.itacademy.desafio.aplicacao.dtos.BatalhaDto;
import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.servicos.AtualizarServico;
import com.itacademy.desafio.dominio.servicos.SelecionarBatalhaServico;
import com.itacademy.desafio.dominio.servicos.StartupServico;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class BatalharUC {
    private final AtualizarServico atualizarServico;


    public BatalharUC(AtualizarServico atualizarServico, StartupServico startupServico, Random r) {
        this.atualizarServico = atualizarServico;

    }
    public BatalhaDto run(String campo, BatalhaDto batalhaDto,  int vl1, int vl2){
        this.atualizarServico.atualizarAvaliacao(batalhaDto.getSt1Id(), vl1, campo);
        this.atualizarServico.atualizarAvaliacao(batalhaDto.getSt2Id(), vl2, campo);
        return batalhaDto;
    }

}

