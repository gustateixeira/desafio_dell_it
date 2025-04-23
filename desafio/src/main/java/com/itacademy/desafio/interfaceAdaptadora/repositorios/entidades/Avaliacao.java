package com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades;

import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@Entity
@ToString
@AllArgsConstructor
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private int pitch;

    private boolean somadoPitch;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private int bugs;

    private boolean somadoBugs;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private int usuarios;

    private boolean somadoUsuarios;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private int investidorIrritado;

    private boolean somadoInvestidor;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private int fakeNews;

    private boolean somadoFakeNews;

    protected Avaliacao(){}

    public Avaliacao(long id, int pitch, int bugs, int usuarios, int investidorIrritado, int fakeNews){
        this.id = id;
        this.pitch = pitch;
        this.bugs = bugs;
        this.usuarios = usuarios;
        this.investidorIrritado = investidorIrritado;
        this.fakeNews = fakeNews;
    }

    public static Avaliacao fromAvaliacaoModel(AvaliacaoModel av){
        return new Avaliacao(av.getId(),
                av.getPitch(),
                av.getBugs(),
                av.getUsuarios(),
                av.getInvestidorIrritado(),
                av.getFakeNews());
    }

    public static AvaliacaoModel toAvaliacaoModel(Avaliacao av){
        return new AvaliacaoModel(av.getId(),
                av.getPitch(),
                av.getBugs(),
                av.getUsuarios(),
                av.getInvestidorIrritado(),
                av.getFakeNews());
    }

    public int[] getAtributos(){
        return new int[]{pitch * 6, bugs * -4, usuarios * 3, investidorIrritado * -6, fakeNews * -8};
    }

    public boolean[] isSomado(){
        return new boolean[]{this.somadoPitch, this.somadoBugs, this.somadoUsuarios,this.somadoInvestidor, this.somadoFakeNews};
    }

}
