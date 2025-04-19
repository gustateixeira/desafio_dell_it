package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import org.hibernate.sql.ast.tree.expression.Star;
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
        List<StartupModel> opcoes = new ArrayList<>(List.copyOf(startups));

        while(opcoes.size() > 2) {
            int index = random.nextInt(opcoes.size() - 1);
            StartupModel key = opcoes.get(index);
            opcoes.remove(index);
            int secIndex = random.nextInt(opcoes.size() - 1);
            StartupModel value = opcoes.get(secIndex);
            opcoes.remove(secIndex);
            sorteio.put(key, value);
        }
        
        StartupModel key = opcoes.getFirst();
        StartupModel value = opcoes.getLast();
        sorteio.put(key,value);

        System.out.println("Sorteio: " + sorteio.toString());

        return sorteio;
    }

}
