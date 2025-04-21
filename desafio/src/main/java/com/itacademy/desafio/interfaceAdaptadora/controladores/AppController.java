package com.itacademy.desafio.interfaceAdaptadora.controladores;


import com.itacademy.desafio.aplicacao.casosDeUso.BatalharUC;
import com.itacademy.desafio.aplicacao.casosDeUso.CriarStartupUC;
import com.itacademy.desafio.aplicacao.casosDeUso.SelecionarBatalhaUC;
import com.itacademy.desafio.aplicacao.casosDeUso.SortearBatalhasUC;
import com.itacademy.desafio.aplicacao.dtos.BatalhaDto;
import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {
    private final CriarStartupUC criarStartupUC;
    private final SortearBatalhasUC sortearBatalhasUC;
    private final SelecionarBatalhaUC selecionarBatalhaUC;
    private final BatalharUC batalharUC;


    public AppController(CriarStartupUC criarStartupUC, SortearBatalhasUC sortearBatalhaUC, SelecionarBatalhaUC selecionarBatalhaUC, BatalharUC batalharUC){
        this.criarStartupUC = criarStartupUC;
        this.sortearBatalhasUC = sortearBatalhaUC;
        this.selecionarBatalhaUC = selecionarBatalhaUC;
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
        List<BatalhaDto> batalhas = sortearBatalhasUC.run();
        StringBuilder str = new StringBuilder();
        int i = 1;
        for(BatalhaDto b : batalhas){
            String st = b.getName1() + " X " + b.getName2();
            str.append("Batalha ").append(i).append(" :").append(st).append('\n');
            i++;
        }
        str.append("\n").append("Escolha uma batalha para controlar, entre 1 e ").append(batalhas.size());
        return str.toString();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/sorteio/escolherBatalha")
    public String escolherBatalha(@RequestParam int id){
        BatalhaDto batalhaEscolhida = this.selecionarBatalhaUC.selecionarBatalha(id);
        return "Batalha Escolhida: " + batalhaEscolhida.getName1() + " x " + batalhaEscolhida.getName2() + "\n";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/sorteio/rodada/{campo}")
    public String batalhar(@PathVariable String campo, @RequestParam int vl1, @RequestParam int vl2){
        return this.batalharUC.run(campo, this.selecionarBatalhaUC.getBatalhaEscolhidaId(), vl1, vl2).toString();
    }

}
