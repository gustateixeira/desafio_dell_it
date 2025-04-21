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

    public BatalhaModel(long id, StartupModel st1, StartupModel st2){
        this.id = id;
        this.st1 = st1;
        this.st2 = st2;
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
