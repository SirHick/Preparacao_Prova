package com.example.prep_prova.Service;


import com.example.prep_prova.Model.Aluguel;
import com.example.prep_prova.Model.Jogo;
import com.example.prep_prova.Repository.AluguelRepository;
import com.example.prep_prova.Repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {

        //Acessar os métodos da tabela Jogo
        @Autowired
        private AluguelRepository aluguelRepository;


        //Metodo para registrar o Aluguel
        @Autowired
        private JogoRepository jogoRepository;

        public Aluguel salvar(Aluguel aluguel){
            //obter o id do jogo enviado pelo Postman
            Long idJogo = aluguel.getJogo().getId();

            //buscar o jogo no banco
            Jogo jogoEncontrado = jogoRepository.findById(idJogo)
                    .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
            if(aluguel.getQuantidade() > jogoEncontrado.getQtd()){
                throw new RuntimeException("Quantidade indisponível para aluguel");
            }

            //atualiza a quantidade disponível
            jogoEncontrado.setQtd(
                    jogoEncontrado.getQtd() - aluguel.getQuantidade()
            );

            //relaciona o jogo do aluguel
            aluguel.setJogo(jogoEncontrado);

            //salvando
            return aluguelRepository.save(aluguel);
        }

        public List<Aluguel> listar(){
            return aluguelRepository.findAll();
        }
    }