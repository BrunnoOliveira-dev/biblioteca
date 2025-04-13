package com.example.biblioteca.controller;

import com.example.biblioteca.entity.Emprestimo;
import com.example.biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Emprestimo")
public class EmprestimoController {

    private final EmprestimoService EmprestimoService;

    public EmprestimoController(EmprestimoService EmprestimoService) {
        this.EmprestimoService = EmprestimoService;
    }

    @GetMapping
    public List<Emprestimo> listarTodos() {
        return EmprestimoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Emprestimo buscarPorId(@PathVariable Integer id) {
        return EmprestimoService.buscarPorId(id);
    }

    @PostMapping
    public Emprestimo salvar(@RequestBody Emprestimo Emprestimo) {
        return EmprestimoService.salvar(Emprestimo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        EmprestimoService.deletar(id);
    }
}