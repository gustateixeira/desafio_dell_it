package com.itacademy.desafio.interfaceAdaptadora.repositorios.implementRepositorios;

import com.itacademy.desafio.dominio.interfaceRepositorios.IAvaliacaoRepositorio;
import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Avaliacao;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.interfacesJpa.AvaliacaoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AvaliacaoREPJpa implements IAvaliacaoRepositorio {
    private final AvaliacaoRepositorio avaliacaoRepositorio;

    public AvaliacaoModel add(AvaliacaoModel av){
        avaliacaoRepositorio.save(Avaliacao.fromAvaliacaoModel(av));
        return av;
    }

    public AvaliacaoModel atualizarAvaliacao(long id,AvaliacaoModel av){
        Avaliacao avaliacao = this.avaliacaoRepositorio.findById(id);
        System.out.println("avaliacao nova: " + avaliacao);
        if(avaliacao.getPitch() < 1){
            avaliacao.setPitch(av.getPitch() + avaliacao.getPitch());
        }
        if(avaliacao.getBugs() < 1){
            avaliacao.setBugs(av.getBugs() + avaliacao.getBugs());
        }
        if(avaliacao.getUsuarios() < 1) {
            avaliacao.setUsuarios(av.getUsuarios() + avaliacao.getUsuarios());
        }
        if(avaliacao.getInvestidorIrritado() < 1){
            avaliacao.setInvestidorIrritado(av.getInvestidorIrritado() + avaliacao.getInvestidorIrritado());
        }
        if(avaliacao.getFakeNews() < 1) {
            avaliacao.setFakeNews(av.getFakeNews() + avaliacao.getFakeNews());
        }
        return Avaliacao.toAvaliacaoModel(this.avaliacaoRepositorio.save(avaliacao));
    }

    public AvaliacaoModel buscarPorId(long id){
        return Avaliacao.toAvaliacaoModel(this.avaliacaoRepositorio.findById(id));
    }

    public List<AvaliacaoModel> buscarTodas(){
        return this.avaliacaoRepositorio.findAll().stream().map(Avaliacao::toAvaliacaoModel).toList();
    }
}
