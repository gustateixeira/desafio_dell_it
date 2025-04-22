package com.itacademy.desafio.dominio.servicos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ChecarBatalhaServico {
    private  Set<String> eventosUsados;
    private List<String> eventosPossiveis;

    public ChecarBatalhaServico(Set<String> eventosUsados) {
        this.eventosUsados = eventosUsados;
        eventosPossiveis = new ArrayList<>();
        eventosPossiveis.add("bugs");
        eventosPossiveis.add("pitch");
        eventosPossiveis.add("investidorirritado");
        eventosPossiveis.add("fakenews");
        eventosPossiveis.add("usuarios");

    }
    public void add(String evento){
        System.out.println(eventosUsados.toString());
        this.eventosUsados.add(evento.toLowerCase());
    }

    public boolean contem(String evento){
        System.out.println("Já foi avaliado: "+ eventosUsados);
        if(!eventosPossiveis.contains(evento.toLowerCase())){
            throw new IllegalArgumentException("Evento tentado não existe: " + evento + ".\nTente esses: pitch | bugs | usuarios | investidorirritado | fakenews");
        }
        if(this.eventosUsados.contains(evento.toLowerCase())){
            return true;
        }
        this.eventosUsados.add(evento.toLowerCase());
        return false;
    }
    public void restart(){
        this.eventosUsados.forEach(el -> eventosUsados.remove(el));

    }
    public int size(){
        return this.eventosUsados.size();
    }
}
