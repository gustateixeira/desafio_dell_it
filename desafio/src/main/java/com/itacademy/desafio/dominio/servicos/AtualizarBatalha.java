package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IBatalhaRepositorio;
import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarBatalha {
    private final IBatalhaRepositorio iBatalhaRepositorio;

    public BatalhaModel setarFinalizada(long id){
        BatalhaModel bt = this.iBatalhaRepositorio.buscarPorId(id);
        bt.setFinalizada(true);
        return this.iBatalhaRepositorio.atualizar(bt);
    }
}
