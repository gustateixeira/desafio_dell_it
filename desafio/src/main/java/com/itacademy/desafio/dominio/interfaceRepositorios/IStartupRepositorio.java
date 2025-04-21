package com.itacademy.desafio.dominio.interfaceRepositorios;


import com.itacademy.desafio.dominio.modelos.StartupModel;

import java.util.List;

public interface IStartupRepositorio {
    public StartupModel add(StartupModel st);
    public List<StartupModel> buscarTodos();
    public StartupModel buscarPorId(long id);
    public StartupModel atualizarPontos(long id, int pts);
}
