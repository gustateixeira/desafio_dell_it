package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IBatalhaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class ChecarBatalhaServico {
    private final IBatalhaRepositorio batalhaRepositorio;

    public boolean checarSeFinalizada(long id){
        return this.batalhaRepositorio.buscarPorId(id).isFinalizada();
    }
}
