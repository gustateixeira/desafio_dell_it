package com.itacademy.desafio.interfaceAdaptadora.repositorios.implementRepositorios;

import com.itacademy.desafio.dominio.interfaceRepositorios.IBatalhaRepositorio;
import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Batalha;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.interfacesJpa.BatalhasRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BatalhaREPJpa implements IBatalhaRepositorio {
    private final BatalhasRepositorio batalhasRepositorio;

    public BatalhaModel add(BatalhaModel batalha){
       return Batalha.toBatalhaModel(this.batalhasRepositorio.save(Batalha.fromBatalhaModel(batalha)));
    }
    public List<BatalhaModel> buscarTodas(){
        return this.batalhasRepositorio.findAll().stream().map(Batalha::toBatalhaModel).toList();
    }
    public BatalhaModel buscarPorId(long id){
        return Batalha.toBatalhaModel(this.batalhasRepositorio.findById(id));
    }
    public BatalhaModel atualizar(BatalhaModel bt){
        Batalha batalha = Batalha.fromBatalhaModel(bt);
        return Batalha.toBatalhaModel(this.batalhasRepositorio.save(batalha));
    }

}
