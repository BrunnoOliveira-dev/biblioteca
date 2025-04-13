package com.example.biblioteca.controller;

import com.example.biblioteca.dto.ExemplarDTO;
import com.example.biblioteca.entity.Exemplares;
import com.example.biblioteca.method.GerarCodigoDeBarras;
import com.example.biblioteca.repository.ExemplaresRepository;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.service.ExemplaresService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exemplares")
public class ExemplaresController {

    private final ExemplaresService ExemplaresService;

    public ExemplaresController(ExemplaresService ExemplaresService) {
        this.ExemplaresService = ExemplaresService;
    }

    @GetMapping
    public List<Exemplares> listarTodos() {
        return ExemplaresService.listarTodos();
    }

    @GetMapping("/{id}")
    public Exemplares buscarPorId(@PathVariable Integer id) {
        return ExemplaresService.buscarPorId(id);
    }

    @PostMapping
    public Exemplares salvar(@RequestBody ExemplarDTO exemplarDTO) {
        if (exemplarDTO.getIdLivro() != null) {
            return ExemplaresService.salvar(exemplarDTO);
        } else if (exemplarDTO.getIsbn() != null) {
            return ExemplaresService.salvar(exemplarDTO);
        }
        return null;
    }

    @PostMapping("/codigoDeBarras")
    public String gerarCodigoDeBarras(@RequestBody String codigoDeBarras) {
        return GerarCodigoDeBarras.gerarCodigoBarrasBase64(codigoDeBarras);
    }

        @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        ExemplaresService.deletar(id);
    }

}