package com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades;

import com.itacademy.desafio.dominio.modelos.StartupModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter

public class Startup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String slogan;
    private int fundacao;
    private @Setter int pontuacao;

    public Startup(long id, String nome, String slogan, int fundacao, int pontuacao){
        this.id = id;
        this.nome = nome;
        this.slogan = slogan;
        this.fundacao = fundacao;
        this.pontuacao = pontuacao;
    }

    protected Startup(){}

    public Startup(String nome, String slogan, int fundacao, int pontuacao){
        this.nome = nome;
        this.slogan = slogan;
        this.fundacao = fundacao;
        this.pontuacao = pontuacao;
    }

    public static Startup fromStartupModel(StartupModel st){
        return new Startup(st.getId(), st.getNome(), st.getSlogan(), st.getFundacao(), st.getPontuacao());
    }

    public static StartupModel toStartupModel(Startup st){
        return new StartupModel(st.getId(), st.getNome(), st.getSlogan(), st.getFundacao(), st.getPontuacao());
    }
}
