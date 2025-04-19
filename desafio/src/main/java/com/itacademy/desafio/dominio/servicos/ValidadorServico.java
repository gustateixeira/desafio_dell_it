package com.itacademy.desafio.dominio.servicos;


import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ValidadorServico {
    private final IStartupRepositorio startupRepositorio;

    public ValidadorServico(IStartupRepositorio startupRepositorio){
        this.startupRepositorio = startupRepositorio;
    }

    public boolean valida(){
        int tam = this.startupRepositorio.buscarTodos().size();
        if(tam % 2 != 0){
            return false;
        }
        return tam >= 4 && tam <= 8;
    }

}
