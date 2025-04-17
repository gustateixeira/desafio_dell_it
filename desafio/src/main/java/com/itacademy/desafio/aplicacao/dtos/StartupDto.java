package com.itacademy.desafio.aplicacao.dtos;

import com.itacademy.desafio.dominio.modelos.StartupModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StartupDto {
    private final long id;
    private final String nome;
    private final String slogan;
    private final int fundacao;
    private int pontuacao;

    public static StartupDto fromModel(StartupModel stModel){
        return new StartupDto(stModel.getId(), stModel.getNome(), stModel.getSlogan(), stModel.getFundacao(), stModel.getPontuacao());
    }
}
