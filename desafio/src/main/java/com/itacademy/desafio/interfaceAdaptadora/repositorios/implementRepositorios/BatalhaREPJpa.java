package com.itacademy.desafio.interfaceAdaptadora.repositorios.implementRepositorios;

import com.itacademy.desafio.dominio.interfaceRepositorios.IBatalhaRepositorio;
import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Batalha;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Startup;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.interfacesJpa.BatalhasRepositorio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BatalhaREPJpa implements IBatalhaRepositorio {
    private final BatalhasRepositorio batalhasRepositorio;

    public BatalhaREPJpa(BatalhasRepositorio batalhasRepositorio) {
        this.batalhasRepositorio = batalhasRepositorio;
    }

    public BatalhaModel add(BatalhaModel batalha){
       return Batalha.toBatalhaModel(this.batalhasRepositorio.save(Batalha.fromBatalhaModel(batalha)));
    }
    public StartupModel vencedor(long id){
       Batalha bt = this.batalhasRepositorio.findById(id);
       return (bt.getSt1().getPontuacao() > bt.getSt2().getPontuacao()) ? Startup.toStartupModel(bt.getSt1()) : Startup.toStartupModel(bt.getSt2());
    }
    public BatalhaModel buscarPorId(long id){
        return Batalha.toBatalhaModel(this.batalhasRepositorio.findById(id));
    }
    public BatalhaModel atualizar(BatalhaModel bt){
        Batalha batalha = Batalha.fromBatalhaModel(bt);
        return Batalha.toBatalhaModel(this.batalhasRepositorio.save(batalha));
    }

}
