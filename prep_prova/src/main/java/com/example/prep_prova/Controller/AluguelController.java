package com.example.prep_prova.Controller;

import com.example.prep_prova.Model.Aluguel;
import com.example.prep_prova.Repository.AluguelRepository;
import com.example.prep_prova.Service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService service;

    @PostMapping
    public Aluguel salvar(@RequestBody Aluguel aluguel){
        return service.salvar(aluguel);
    }

    @GetMapping
    public List<Aluguel> listar(){
        return service.listar();
    }
}
