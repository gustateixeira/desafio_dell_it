package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IBatalhaRepositorio;
import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import org.springframework.stereotype.Service;


@Service
public class SelecionarBatalhaServico {
    private final IBatalhaRepositorio batalhaRepositorio;



    public SelecionarBatalhaServico(IBatalhaRepositorio batalhaRepositorio) {
        this.batalhaRepositorio = batalhaRepositorio;
    }

    public BatalhaModel selecionarBatalha(long id){
        return this.batalhaRepositorio.buscarPorId(id);
    }

}
