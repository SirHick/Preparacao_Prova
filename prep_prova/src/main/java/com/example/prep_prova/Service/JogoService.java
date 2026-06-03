package com.example.prep_prova.Service;


import com.example.prep_prova.Model.Jogo;
import com.example.prep_prova.Repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    //Salvar jogo

    public Jogo salvar (Jogo jogo){
        return jogoRepository.save(jogo);
    }

    //Listar tudo
    public List<Jogo> listar(){
        return jogoRepository.findAll();
    }

    //Buscar pelo id
    public Jogo buscarPorId (Long id){
        return jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException ("Jogo não encontrado"));
    }
}
