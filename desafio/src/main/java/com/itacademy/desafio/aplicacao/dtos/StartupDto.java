package com.itacademy.desafio.aplicacao.dtos;

import com.itacademy.desafio.dominio.modelos.StartupModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class StartupDto {
    private final long id;
    private final String nome;
    private final String slogan;
    private final long avaliacaoId;
    private final int fundacao;
    private final int pontuacao;



    public static StartupDto fromModel(StartupModel stModel){
        return new StartupDto(stModel.getId(),stModel.getNome(), stModel.getSlogan(), stModel.getAv().getId(),stModel.getFundacao(), stModel.getPontuacao());
    }
}
