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

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private int bugs;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private int usuarios;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private int investidorIrritado;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private int fakeNews;

    protected Avaliacao(){}

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

}
