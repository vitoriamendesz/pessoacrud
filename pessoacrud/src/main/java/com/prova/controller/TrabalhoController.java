package com.pessoa.pessoa.controller;

import com.pessoa.pessoa.entity.Trabalho;
import com.pessoa.pessoa.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoRepository repository;

    @PostMapping
    public Trabalho criar(@RequestBody Trabalho trabalho) {
        return repository.save(trabalho);
    }

    @GetMapping
    public List<Trabalho> listar() {
        return repository.findAll();
    }
}

