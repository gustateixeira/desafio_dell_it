package com.itacademy.desafio.dominio.interfaceRepositorios;

import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import com.itacademy.desafio.dominio.modelos.StartupModel;

public interface IBatalhaRepositorio {
    public BatalhaModel add(BatalhaModel bt);
    public StartupModel vencedor(long id);
    public BatalhaModel buscarPorId(long id);
    public BatalhaModel atualizar(BatalhaModel bt);
}
