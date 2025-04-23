package com.itacademy.desafio.aplicacao.dtos;

import com.itacademy.desafio.dominio.modelos.StartupModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class StartupDto{
    private final long id;
    private final String nome;
    private final String slogan;
    private final AvaliacaoDto avaliacao;
    private final int fundacao;
    private final int pontuacao;



    public static StartupDto fromModel(StartupModel stModel){
        return new StartupDto(stModel.getId(),stModel.getNome(), stModel.getSlogan(), AvaliacaoDto.fromModel(stModel.getAv()),stModel.getFundacao(), stModel.getPontuacao());
    }

}
