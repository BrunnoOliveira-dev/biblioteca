package com.example.biblioteca.service;

import com.example.biblioteca.entity.Exemplares;
import com.example.biblioteca.entity.Livro;
import com.example.biblioteca.repository.ExemplaresRepository;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    private final ExemplaresRepository exemplaresRepository;

    public LivroService(LivroRepository livroRepository, ExemplaresRepository exemplaresRepository) {
        this.livroRepository = livroRepository;
        this.exemplaresRepository = exemplaresRepository;
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Integer id) {
        return livroRepository.findById(id).orElse(null);
    }

    public Livro salvar(Livro livro /*, int numeroExemplares */) {
        /*Livro savedLivro = */
        return livroRepository.save(livro);



        /*
        List<Exemplares> exemplaresList = new ArrayList<>();
        for (int i = 0; i < numeroExemplares; i++) {
            Exemplares exemplar = new Exemplares();
            exemplar.setLivro(savedLivro);
            exemplaresList.add(exemplar);
        }

        exemplaresRepository.saveAll(exemplaresList);
        return savedLivro;
        */


    }

    public void deletar(Integer id) {
        livroRepository.deleteById(id);
    }
}