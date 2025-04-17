package com.itacademy.desafio.aplicacao.dtos;

import com.itacademy.desafio.dominio.modelos.StartupModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class StartupDto {
    private final String nome;
    private final String slogan;
    private final int fundacao;
    private final int pontuacao;

    public StartupDto(String nome, String slogan, int fundacao, Integer pontuacao){
        this.nome = nome;
        this.slogan = slogan;
        this.fundacao = fundacao;
        this.pontuacao = (pontuacao == null) ? 70 : pontuacao;
    }


    public static StartupDto fromModel(StartupModel stModel){
        return new StartupDto(stModel.getNome(), stModel.getSlogan(), stModel.getFundacao(), stModel.getPontuacao());
    }
}
