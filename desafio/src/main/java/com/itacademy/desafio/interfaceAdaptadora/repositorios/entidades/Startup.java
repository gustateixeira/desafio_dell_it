package com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades;

import com.itacademy.desafio.dominio.modelos.StartupModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
public class Startup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_avaliacao")
    private Avaliacao av;

    private String slogan;
    private int fundacao;
    @Column(columnDefinition = "INTEGER DEFAULT 70")
    private @Setter int pontuacao;



    protected Startup(){}


    public static Startup fromStartupModel(StartupModel st){
        return new Startup(st.getId(), st.getNome(), Avaliacao.fromAvaliacaoModel(st.getAv()),st.getSlogan(), st.getFundacao(), st.getPontuacao());
    }

    public static StartupModel toStartupModel(Startup st){
        return new StartupModel(st.getId(), st.getNome(), Avaliacao.toAvaliacaoModel(st.getAv()) , st.getSlogan(), st.getFundacao(), st.getPontuacao());
    }
}
