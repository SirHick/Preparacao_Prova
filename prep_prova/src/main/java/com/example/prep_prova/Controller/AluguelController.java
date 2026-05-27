package com.example.prep_prova.Controller;

import com.example.prep_prova.Model.Aluguel;
import com.example.prep_prova.Repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelRepository repository;

    @PostMapping
    public Aluguel salvar(@RequestBody Aluguel aluguel){
        return repository.save(aluguel);
    }

    @GetMapping
    public List<Aluguel> listar(){
        return repository.findAll();
    }
}
