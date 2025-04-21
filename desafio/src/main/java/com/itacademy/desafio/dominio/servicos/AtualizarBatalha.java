package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IBatalhaRepositorio;
import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import org.springframework.stereotype.Service;

@Service
public class AtualizarBatalha {
    private final IBatalhaRepositorio iBatalhaRepositorio;


    public AtualizarBatalha(IBatalhaRepositorio iBatalhaRepositorio) {
        this.iBatalhaRepositorio = iBatalhaRepositorio;
    }

    public BatalhaModel setarFinalizada(long id){
        BatalhaModel bt = this.iBatalhaRepositorio.buscarPorId(id);
        bt.setFinalizada(true);
        return this.iBatalhaRepositorio.atualizar(bt);
    }
}
