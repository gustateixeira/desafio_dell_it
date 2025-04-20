package com.itacademy.desafio.aplicacao.dtos;


import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class AvaliacaoDto {
    private long id;
    private int pitch;
    private int bugs;
    private int usuarios;
    private int investidorIrritado;
    private int fakeNews;


    public static AvaliacaoDto fromModel(AvaliacaoModel avModel){
        return new AvaliacaoDto(avModel.getId(),
                avModel.getPitch(), avModel.getBugs(),
                avModel.getUsuarios(),
                avModel.getInvestidorIrritado(),
                avModel.getFakeNews());
    }
}
