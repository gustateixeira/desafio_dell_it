package com.itacademy.desafio.dominio.modelos;


import lombok.*;

@ToString
@Getter
public class StartupModel {
    private long id;
    private final String nome;
    private final String slogan;
    private final int fundacao;
    private @Setter int pontuacao;

    public StartupModel(long id,String nome, String slogan, int fundacao, int pontuacao){
        this.id = id;
        this.nome = nome;
        this.slogan = slogan;
        this.fundacao = fundacao;
        this.pontuacao = pontuacao;
    }
    public StartupModel(String nome, String slogan, int fundacao){
        this.nome = nome;
        this.slogan = slogan;
        this.fundacao = fundacao;
        this.pontuacao = 70;
    }
}
