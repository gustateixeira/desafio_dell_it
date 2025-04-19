package com.itacademy.desafio.dominio.modelos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class AvaliacaoModel {
    private long id;
    private final int pitch;
    private final int bugs;
    private final int usuarios;
    private final int investidorIrritado;
    private final int fakeNews;

    public AvaliacaoModel(){
        pitch = 0;
        bugs = 0;
        usuarios = 0;
        investidorIrritado = 0;
        fakeNews = 0;
    }
}
