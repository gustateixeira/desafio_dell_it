package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IAvaliacaoRepositorio;
import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoServico {
    private final IAvaliacaoRepositorio iAvaliacaoRepositorio;

    public AvaliacaoServico(IAvaliacaoRepositorio iAvaliacaoRepositorio) {
        this.iAvaliacaoRepositorio = iAvaliacaoRepositorio;
    }
    public AvaliacaoModel buscarPorId(long id){
        return this.iAvaliacaoRepositorio.buscarPorId(id);
    }
    public List<AvaliacaoModel> buscarTodas(){
        return this.iAvaliacaoRepositorio.buscarTodas();
    }
}
