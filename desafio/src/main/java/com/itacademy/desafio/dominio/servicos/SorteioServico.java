package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IBatalhaRepositorio;
import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@AllArgsConstructor
@Service
public class SorteioServico{

    /*TODO: criar um serviço que sorteie quais startups se enfrentarão com base no id delas
      TODO: criar um UC para poder coordenar as batalhas
    * */
    private final Random random;
    private final IStartupRepositorio startupRepositorio;
    private final IBatalhaRepositorio batalhaRepositorio;


    public List<BatalhaModel> sortear(){
        List<StartupModel> startups = new ArrayList<>(this.startupRepositorio.buscarTodos());
        List<BatalhaModel> batalhas = new ArrayList<>();


        Collections.shuffle(startups, this.random);

        for (int i = 0; i < startups.size() - 1; i += 2) {
            StartupModel st1 = startups.get(i);
            StartupModel st2 = startups.get(i + 1);
            BatalhaModel batalha = new BatalhaModel(st1, st2);
            System.out.println(batalha.toString());
            batalhas.add(batalhaRepositorio.add(batalha));
        }

        return batalhas;
    }
    public List<BatalhaModel> sortear(List<StartupModel> startupModels){
        List<StartupModel> startups = new ArrayList<>(startupModels);
        List<BatalhaModel> batalhas = new ArrayList<>();


        Collections.shuffle(startups, this.random);

        for (int i = 0; i < startups.size() - 1; i += 2) {
            StartupModel st1 = startups.get(i);
            StartupModel st2 = startups.get(i + 1);
            BatalhaModel batalha = new BatalhaModel(st1, st2);
            System.out.println(batalha.toString());
            batalhas.add(batalhaRepositorio.add(batalha));
        }

        return batalhas;
    }

}
