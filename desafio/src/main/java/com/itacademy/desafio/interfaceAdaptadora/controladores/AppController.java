package com.itacademy.desafio.interfaceAdaptadora.controladores;


import com.itacademy.desafio.aplicacao.casosDeUso.*;
import com.itacademy.desafio.aplicacao.dtos.AvaliacaoDto;
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
    private final DefinirGanhadorUC definirGanhadorUC;
    private final MostarStartupsUC mostarStartupsUC;


    public AppController(CriarStartupUC criarStartupUC, SortearBatalhasUC sortearBatalhaUC, SelecionarBatalhaUC selecionarBatalhaUC, BatalharUC batalharUC, DefinirGanhadorUC definirGanhadorUC, MostarStartupsUC mostarStartupsUC){
        this.criarStartupUC = criarStartupUC;
        this.sortearBatalhasUC = sortearBatalhaUC;
        this.selecionarBatalhaUC = selecionarBatalhaUC;
        this.batalharUC = batalharUC;
        this.definirGanhadorUC = definirGanhadorUC;
        this.mostarStartupsUC = mostarStartupsUC;
    }
    @CrossOrigin(origins="*")
    @GetMapping("")
    public String home(){
        return "Desafio da Dell IT Academy 2025";
    }

    @CrossOrigin(origins="*")
    @GetMapping("/listarStartups")
    public List<StartupDto> mostrarTodas(){
        return this.mostarStartupsUC.run();
    }
    @CrossOrigin(origins ="*")
    @PostMapping("/criarStartup")
    public StartupDto criarStartup(@RequestBody StartupDto st){
        return criarStartupUC.run(st);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/sorteio")
    public List<BatalhaDto> iniciarSorteio(){
        return sortearBatalhasUC.run();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/sorteio/escolherBatalha")
    public String escolherBatalha(@RequestParam int id){
        BatalhaDto batalhaEscolhida = this.selecionarBatalhaUC.selecionarBatalha(id);
        return "Batalha Escolhida: " + batalhaEscolhida.getName1() + " x " + batalhaEscolhida.getName2() + "\n";
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/sorteio/rodada/{batalhaid}")
    public BatalhaDto batalhar(@PathVariable long batalhaid, @RequestBody List<AvaliacaoDto> avaliacaoDtos){
        return this.batalharUC.run(batalhaid, avaliacaoDtos.get(0), avaliacaoDtos.get(1));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/sorteio/rodada/ganhador")
    public String ganhador(){
        return this.definirGanhadorUC.run(this.selecionarBatalhaUC.getBatalhaEscolhidaId().getId()).toString();
    }

}
