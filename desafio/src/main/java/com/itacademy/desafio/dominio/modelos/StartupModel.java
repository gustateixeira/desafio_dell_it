package com.itacademy.desafio.dominio.modelos;


import lombok.*;

@ToString
@Getter
@AllArgsConstructor
public class StartupModel {
    private long id;
    private final String nome;
    private AvaliacaoModel av;
    private final String slogan;
    private final int fundacao;
    private @Setter int pontuacao;

    public StartupModel(String nome, String slogan, int fundacao){
        this.nome = nome;
        this.av = new AvaliacaoModel();
        this.slogan = slogan;
        this.fundacao = fundacao;
        this.pontuacao = 70;
    }

}
