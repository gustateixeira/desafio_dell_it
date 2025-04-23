package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CadastrarServico {
    private final IStartupRepositorio startupRepositorio;

    public StartupModel cadastrarStartup(StartupModel st){
        return this.startupRepositorio.add(st);
    }
}
