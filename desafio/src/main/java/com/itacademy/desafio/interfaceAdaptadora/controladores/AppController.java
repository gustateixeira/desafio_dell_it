package com.itacademy.desafio.interfaceAdaptadora.controladores;


import com.itacademy.desafio.aplicacao.casosDeUso.CriarStartupUC;
import com.itacademy.desafio.aplicacao.casosDeUso.IniciarBatalhaUC;
import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import org.hibernate.sql.ast.tree.expression.Star;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
    private final CriarStartupUC criarStartupUC;
    private final IniciarBatalhaUC iniciarBatalhaUC;

    public AppController(CriarStartupUC criarStartupUC, IniciarBatalhaUC iniciarBatalhaUC){
        this.criarStartupUC = criarStartupUC;
        this.iniciarBatalhaUC = iniciarBatalhaUC;
    }
    @CrossOrigin(origins="*")
    @GetMapping("")
    public String home(){
        return "Desafio da Dell IT Academy 2025";
    }

    @CrossOrigin(origins ="*")
    @PostMapping("/criarStartup")
    public StartupDto criarStartup(@RequestBody StartupDto st){
        criarStartupUC.run(st);
        return st;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/sorteio/iniciar")
    public String iniciarSorteio(){
        return iniciarBatalhaUC.run().toString();
    }
}
