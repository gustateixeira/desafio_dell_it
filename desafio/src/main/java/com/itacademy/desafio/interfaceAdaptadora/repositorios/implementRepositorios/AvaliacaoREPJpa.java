package com.itacademy.desafio.interfaceAdaptadora.repositorios.implementRepositorios;

import com.itacademy.desafio.dominio.interfaceRepositorios.IAvaliacaoRepositorio;
import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Avaliacao;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.interfacesJpa.AvaliacaoRepositorio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AvaliacaoREPJpa implements IAvaliacaoRepositorio {
    private final AvaliacaoRepositorio avaliacaoRepositorio;

    public AvaliacaoREPJpa(AvaliacaoRepositorio av){
        this.avaliacaoRepositorio = av;
    }

    public AvaliacaoModel add(AvaliacaoModel av){
        avaliacaoRepositorio.save(Avaliacao.fromAvaliacaoModel(av));
        return av;
    }

    public AvaliacaoModel atualizarAvaliacao(long id,AvaliacaoModel av){
        Avaliacao avaliacao = this.avaliacaoRepositorio.findById(id);
        avaliacao.setPitch(av.getPitch() + avaliacao.getPitch());
        avaliacao.setBugs(av.getBugs() + avaliacao.getBugs());
        avaliacao.setUsuarios(av.getUsuarios() + avaliacao.getUsuarios());
        avaliacao.setInvestidorIrritado(av.getInvestidorIrritado() + avaliacao.getInvestidorIrritado());
        avaliacao.setFakeNews(av.getFakeNews() + avaliacao.getFakeNews());
        return Avaliacao.toAvaliacaoModel(this.avaliacaoRepositorio.save(avaliacao));
    }

}
