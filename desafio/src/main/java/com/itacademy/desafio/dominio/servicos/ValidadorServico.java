package com.itacademy.desafio.dominio.servicos;


import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ValidadorServico {
    private final IStartupRepositorio startupRepositorio;

    public boolean valida(){
        int tam = this.startupRepositorio.buscarTodos().size();
        return tam == 4 || tam == 8;
    }
    public boolean isLast(List<StartupModel> list){
        return list.size() != 1;
    }

}
