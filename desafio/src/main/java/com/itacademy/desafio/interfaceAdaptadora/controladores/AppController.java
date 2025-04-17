package com.itacademy.desafio.interfaceAdaptadora.controladores;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @CrossOrigin(origins="*")
    @GetMapping("")
    public String home(){
        return "Desafio da Dell IT Academy 2025";
    }

}
