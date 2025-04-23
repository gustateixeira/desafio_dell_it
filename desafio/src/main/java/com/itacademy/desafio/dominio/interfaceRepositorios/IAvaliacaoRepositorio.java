package com.itacademy.desafio.dominio.interfaceRepositorios;

import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;

import java.util.List;


public interface IAvaliacaoRepositorio {
    public AvaliacaoModel add(AvaliacaoModel av);
    public AvaliacaoModel atualizarAvaliacao(long id,AvaliacaoModel av);
    public AvaliacaoModel buscarPorId(long id);
    public List<AvaliacaoModel> buscarTodas();
}
