package com.itacademy.desafio.interfaceAdaptadora.repositorios.interfacesJpa;

import org.springframework.data.repository.CrudRepository;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Startup;

import java.util.List;

public interface StartupRepositorio extends CrudRepository<Startup, Long> {
    @Override
    public List<Startup> findAll();
    public Startup findById(long id);
}
