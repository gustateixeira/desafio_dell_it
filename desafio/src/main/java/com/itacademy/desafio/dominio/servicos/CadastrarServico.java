package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import org.springframework.stereotype.Service;

@Service
public class CadastrarServico {
    private final IStartupRepositorio startupRepositorio;

    public CadastrarServico(IStartupRepositorio startupRepositorio){
        this.startupRepositorio = startupRepositorio;
    }

    public StartupModel cadastrarStartup(StartupModel st){
        return this.startupRepositorio.add(st);
    }
}
