package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import com.itacademy.desafio.dominio.servicos.BatalhaServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BatalhasFinalizadasUC {
    private final BatalhaServico batalhaServico;

    public boolean run(){
        return this.batalhaServico.buscarTodas().stream().allMatch(BatalhaModel::isFinalizada);
    }
}
