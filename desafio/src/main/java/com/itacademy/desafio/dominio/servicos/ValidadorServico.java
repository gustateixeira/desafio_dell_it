package com.itacademy.desafio.dominio.servicos;


import java.util.List;
import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;
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
        return tam >= 2 && tam <= 8;
    }

}
