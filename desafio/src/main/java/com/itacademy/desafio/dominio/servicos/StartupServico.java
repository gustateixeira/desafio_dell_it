package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StartupServico {
    private final IStartupRepositorio startupRepositorio;

    public List<StartupModel> listar(){
        return this.startupRepositorio.buscarTodos();
    }

    public StartupModel buscar(long id){
        return this.startupRepositorio.buscarPorId(id);
    }
}

