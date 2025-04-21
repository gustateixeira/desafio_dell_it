package com.itacademy.desafio.interfaceAdaptadora.repositorios.interfacesJpa;

import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Batalha;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BatalhasRepositorio extends CrudRepository<Batalha, Long> {
    public Batalha findById(long id);
    public List<Batalha> findAll();
}
