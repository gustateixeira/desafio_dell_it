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

    public AvaliacaoModel atualizarAvaliacao(long id, int valor, String campo){
        Avaliacao av = avaliacaoRepositorio.findById(id);
        switch (campo.toLowerCase()) {
            case "pitch":
                av.setPitch(valor);
                break;
            case "bugs":
                av.setBugs(valor);
                break;
            case "usuarios":
                av.setUsuarios(valor);
                break;
            case "investidorirritado":
                av.setInvestidorIrritado(valor);
                break;
            case "fakenews":
                av.setFakeNews(valor);
                break;
        }

        avaliacaoRepositorio.save(av);
        return Avaliacao.toAvaliacaoModel(av);
    }

}
