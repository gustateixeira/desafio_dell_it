package com.itacademy.desafio.dominio.servicos;

import com.itacademy.desafio.dominio.interfaceRepositorios.IBatalhaRepositorio;
import com.itacademy.desafio.dominio.modelos.BatalhaModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BatalhaServico {
    private final IBatalhaRepositorio iBatalhaRepositorio;

    public List<BatalhaModel> buscarTodas(){
        return this.iBatalhaRepositorio.buscarTodas();
    }
}
