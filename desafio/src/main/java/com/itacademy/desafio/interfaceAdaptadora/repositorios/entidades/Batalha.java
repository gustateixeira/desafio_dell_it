package com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades;

import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@AllArgsConstructor
@Getter
public class Batalha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "id_startup1")
    private Startup st1;

    @OneToOne
    @JoinColumn(name = "id_startup2")
    private Startup st2;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private @Setter boolean finalizada;

    @OneToOne
    @JoinColumn(name = "id_startup_vencedor", nullable = true)
    private @Setter Startup vencedor;

    protected Batalha(){}

    public static Batalha fromBatalhaModel(BatalhaModel batalhaModel){
        return new Batalha(batalhaModel.getId(), Startup.fromStartupModel(batalhaModel.getSt1()), Startup.fromStartupModel(batalhaModel.getSt2()), batalhaModel.isFinalizada(),  Startup.fromStartupModel(batalhaModel.getVencedor()));
    }

    public static BatalhaModel toBatalhaModel(Batalha batalha){
        return new BatalhaModel(batalha.getId(), Startup.toStartupModel(batalha.getSt1()), Startup.toStartupModel(batalha.getSt2()),Startup.toStartupModel(batalha.getVencedor()) ,batalha.isFinalizada());
    }

}
