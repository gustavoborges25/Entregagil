package com.time06.escoladeti.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public void update(Endereco endereco) {
        repository.save(endereco);
    }

}