package com.itacademy.desafio.interfaceAdaptadora.controladores;


import com.itacademy.desafio.aplicacao.casosDeUso.BatalharUC;
import com.itacademy.desafio.aplicacao.casosDeUso.CriarStartupUC;
import com.itacademy.desafio.aplicacao.casosDeUso.IniciarBatalhaUC;
import com.itacademy.desafio.aplicacao.dtos.AvaliacaoDto;
import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import org.hibernate.sql.ast.tree.expression.Star;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AppController {
    private final CriarStartupUC criarStartupUC;
    private final IniciarBatalhaUC iniciarBatalhaUC;
    private final BatalharUC batalharUC;
    private Map<StartupDto, StartupDto> sorteio;
    private int batalhaSel;


    public AppController(CriarStartupUC criarStartupUC, IniciarBatalhaUC iniciarBatalhaUC, BatalharUC batalharUC){
        this.criarStartupUC = criarStartupUC;
        this.iniciarBatalhaUC = iniciarBatalhaUC;
        this.batalharUC = batalharUC;
    }
    @CrossOrigin(origins="*")
    @GetMapping("")
    public String home(){
        return "Desafio da Dell IT Academy 2025";
    }

    @CrossOrigin(origins ="*")
    @PostMapping("/criarStartup")
    public StartupDto criarStartup(@RequestBody StartupDto st){
        return criarStartupUC.run(st);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/sorteio/iniciar")
    public String iniciarSorteio(){
        this.sorteio = iniciarBatalhaUC.run();
        StringBuilder str = new StringBuilder();
        int i = 1;
        for(StartupDto key : sorteio.keySet()){
            StartupDto value = sorteio.get(key);
            String st = key.getNome() + " X " + value.getNome();
            str.append("Batalha ").append(i).append(" :").append(st).append('\n');
            i++;
        }
        str.append("\n").append("Escolha uma batalha para controlar");
        return str.toString();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/sorteio/escolherBatalha")
    public String escolherBatalha(@RequestParam int index){
        this.batalhaSel = index;
        StartupDto key = (StartupDto) this.sorteio.keySet().toArray()[index];
        return "Batalha Escolhida ---->  " + key.getNome() + " X " + this.sorteio.get(key).getNome() + "\n" + "Iniciar Rodada de Pitch \n";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/sorteio/rodada/pitch")
    public String atribuirPitch(@RequestParam int startup, @RequestParam int startup2){
        return ""; //TODO: CRIAR OS ENDPOINTS PARA IR MEXENDO NAS AVALIACOES
    }

}
