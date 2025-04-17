package com.itacademy.desafio.dominio.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public class StartupModel {
    private final long id;
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
}
