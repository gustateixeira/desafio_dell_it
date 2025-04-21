package com.itacademy.desafio.aplicacao.dtos;

import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;
import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BatalhaDto {
    private long id;
    private long st1Id;
    private String name1;
    private long st2Id;
    private String name2;


    public static BatalhaDto fromModel(BatalhaModel bt){
        return new BatalhaDto(bt.getId(), bt.getSt1().getId(), bt.getSt1().getNome(), bt.getSt2().getId(), bt.getSt2().getNome());
    }
}
