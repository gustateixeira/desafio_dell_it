package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SorteioServico{

    /*TODO: criar um serviço que sorteie quais startups se enfrentarão com base no id delas
      TODO: criar um UC para poder coordenar as batalhas
    * */
    private final Random random;
    private final IStartupRepositorio startupRepositorio;

    public SorteioServico(Random r ,IStartupRepositorio startupRepositorio){
        this.random = r;
        this.startupRepositorio = startupRepositorio;
    }

    public Map<StartupModel, StartupModel> sortear(){
        Map<StartupModel, StartupModel> sorteio = new HashMap<>();
        List<StartupModel> startups = this.startupRepositorio.buscarTodos();
        Collections.shuffle(startups);

        for(int i = 0; i < startups.size()-1; i++){
            sorteio.put(startups.get(i), startups.get(i+1));
        }

        return sorteio;
    }

}
