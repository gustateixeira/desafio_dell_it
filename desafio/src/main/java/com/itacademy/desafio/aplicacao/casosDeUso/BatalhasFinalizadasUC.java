package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import com.itacademy.desafio.dominio.servicos.BatalhaServico;
import org.springframework.stereotype.Component;

@Component
public class BatalhasFinalizadasUC {
    private final BatalhaServico batalhaServico;

    public BatalhasFinalizadasUC(BatalhaServico batalhaServico) {
        this.batalhaServico = batalhaServico;
    }
    public boolean run(){
        return this.batalhaServico.buscarTodas().stream().allMatch(BatalhaModel::isFinalizada);
    }
}
