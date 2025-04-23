package com.itacademy.desafio.interfaceAdaptadora.repositorios.interfacesJpa;

import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Avaliacao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvaliacaoRepositorio extends CrudRepository<Avaliacao,Long> {
    public Avaliacao findById(long id);
    public Avaliacao save(Avaliacao av);
    public List<Avaliacao> findAll();
}
