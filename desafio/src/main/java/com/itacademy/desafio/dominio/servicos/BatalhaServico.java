package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IBatalhaRepositorio;
import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatalhaServico {
    private final IBatalhaRepositorio iBatalhaRepositorio;

    public BatalhaServico(IBatalhaRepositorio iBatalhaRepositorio) {
        this.iBatalhaRepositorio = iBatalhaRepositorio;
    }
    public List<BatalhaModel> buscarTodas(){
        return this.iBatalhaRepositorio.buscarTodas();
    }
}
