package com.itacademy.desafio.dominio.interfaceRepositorios;

import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import java.util.List;
public interface IBatalhaRepositorio {
    public BatalhaModel add(BatalhaModel bt);
    public BatalhaModel buscarPorId(long id);
    public List<BatalhaModel> buscarTodas();

    public BatalhaModel atualizar(BatalhaModel bt);
}
