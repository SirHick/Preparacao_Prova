package com.example.prep_prova.Controller;

import com.example.prep_prova.Model.Jogo;
import com.example.prep_prova.Service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; //LISTA

@RestController
@RequestMapping ("/jogos")

public class JogoController {
    //Anotação que vai instruir a Spring a procurar uma instância pronta
    @Autowired
    private JogoService service;

    //POST
    @PostMapping
    public Jogo salvar(@RequestBody Jogo jogo){
        return service.salvar(jogo);
    }

    //GET (java.util)
    @GetMapping
    public List<Jogo> listar(){
        return service.listar();
    }

    //PUT



    //DELETE
}
