package com.itacademy.desafio.interfaceAdaptadora.controladores;


import com.itacademy.desafio.aplicacao.casosDeUso.CriarStartupUC;
import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import org.hibernate.sql.ast.tree.expression.Star;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
    private final CriarStartupUC criarStartupUC;

    public AppController(CriarStartupUC criarStartupUC){
        this.criarStartupUC = criarStartupUC;
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
}
