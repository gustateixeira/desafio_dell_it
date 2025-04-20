package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import org.springframework.stereotype.Service;


@Service
public class SelecionarBatalhaServico {
    private final IStartupRepositorio startupRepositorio;


    public SelecionarBatalhaServico(IStartupRepositorio startupRepositorio) {
        this.startupRepositorio = startupRepositorio;
    }

    public StartupModel selecionarBatalha(long id){
        return  this.startupRepositorio.buscarPorId(id);
    }
}
