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

    public AvaliacaoModel atualizarAvaliacao(long id, int pitch, int bugs, int usuarios, int investidorIrritado, int fakeNews){
        Avaliacao av = avaliacaoRepositorio.findById(id);
        av.setPitch(pitch);
        av.setBugs(bugs);
        av.setUsuarios(usuarios);
        av.setInvestidorIrritado(investidorIrritado);
        av.setFakeNews(fakeNews);
        avaliacaoRepositorio.save(av);
        return Avaliacao.toAvaliacaoModel(av);
    }

}
