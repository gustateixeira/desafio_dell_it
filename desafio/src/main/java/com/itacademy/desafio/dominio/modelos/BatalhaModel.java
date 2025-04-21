package com.itacademy.desafio.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class BatalhaModel {
    private long id;
    private StartupModel st1;
    private StartupModel st2;
    private @Setter StartupModel vencedor;
    private @Setter boolean finalizada;

    public BatalhaModel(long id, StartupModel st1, StartupModel st2, boolean finalizada){
        this.id = id;
        this.st1 = st1;
        this.st2 = st2;
        this.finalizada = finalizada;
    }
    public BatalhaModel(StartupModel st1, StartupModel st2){
        this.st1 = st1;
        this.st2 = st2;
    }
    @Override
    public String toString(){
        return "Batalha: " + st1.getNome() + " x " + st2.getNome();
    }
}
