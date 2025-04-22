package com.itacademy.desafio.dominio.interfaceRepositorios;

import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;


public interface IAvaliacaoRepositorio {
    public AvaliacaoModel add(AvaliacaoModel av);
    public AvaliacaoModel atualizarAvaliacao(long id,AvaliacaoModel av);
}
