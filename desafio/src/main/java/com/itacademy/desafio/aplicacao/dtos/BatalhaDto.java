package com.itacademy.desafio.aplicacao.dtos;

import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class BatalhaDto {
    private long id;
    private long st1Id;
    private String name1;
    private long st2Id;
    private String name2;
    private @Setter boolean finalizada;
    private @Setter long vencedorId;

    public BatalhaDto(long id, long st1Id, String name1, long st2Id, String name2, boolean finalizada) {
        this.id = id;
        this.st1Id = st1Id;
        this.name1 = name1;
        this.st2Id = st2Id;
        this.name2 = name2;
        this.finalizada = finalizada;
    }





    public static BatalhaDto fromModel(BatalhaModel bt){
        return new BatalhaDto(bt.getId(), bt.getSt1().getId(), bt.getSt1().getNome(), bt.getSt2().getId(), bt.getSt2().getNome(), bt.isFinalizada());
    }
}
