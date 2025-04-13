package com.example.biblioteca.controller;

import com.example.biblioteca.entity.Livro;
import com.example.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Integer id) {
        return livroService.buscarPorId(id);
    }

    @PostMapping
    public Livro salvar(@RequestBody Livro livro /* @RequestParam int numeroExemplares */) {
        return livroService.salvar(livro); /*, numeroExemplares);*/
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        livroService.deletar(id);
    }
}