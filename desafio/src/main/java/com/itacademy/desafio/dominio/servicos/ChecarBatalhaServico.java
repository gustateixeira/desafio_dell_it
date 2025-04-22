package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IBatalhaRepositorio;
import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ChecarBatalhaServico {
    private final IBatalhaRepositorio batalhaRepositorio;
    public ChecarBatalhaServico(IBatalhaRepositorio batalhaRepositorio) {
        this.batalhaRepositorio = batalhaRepositorio;
    }
    public boolean checarSeFinalizada(long id){
        return this.batalhaRepositorio.buscarPorId(id).isFinalizada();
    }
}
