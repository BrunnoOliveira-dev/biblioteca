package com.example.biblioteca.service;

import com.example.biblioteca.dto.ExemplarDTO;
import com.example.biblioteca.entity.Exemplares;
import com.example.biblioteca.entity.Livro;
import com.example.biblioteca.repository.ExemplaresRepository;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemplaresService {
    private final ExemplaresRepository ExemplaresRepository;
    private final LivroRepository livroRepository;
    private final ExemplaresRepository exemplaresRepository;

    public ExemplaresService(ExemplaresRepository ExemplaresRepository, LivroRepository livroRepository, ExemplaresRepository exemplaresRepository) {
        this.ExemplaresRepository = ExemplaresRepository;
        this.livroRepository = livroRepository;
        this.exemplaresRepository = exemplaresRepository;
    }

    public List<Exemplares> listarTodos() {
        return ExemplaresRepository.findAll();
    }

    public Exemplares buscarPorId(Integer id) {
        return ExemplaresRepository.findById(id).orElse(null);
    }

    public Exemplares salvar(ExemplarDTO exemplarDTO) {
        // Busca o livro pelo ID fornecido no DTO
        int idLivro = exemplarDTO.getIdLivro();
        Livro livro = livroRepository.findById(exemplarDTO.getIdLivro())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado!"));

        String codigoDeBarras = livro.getISBN() + "-" + String.format("%03d", exemplaresRepository.countByLivroId(livro.getId_livro()) + 1);

        // Criando o objeto Exemplar
        Exemplares exemplar = new Exemplares();
        exemplar.setLivro(livro); // Associando o livro corretamente
        exemplar.setDisponivel(exemplarDTO.isDisponivel());
        exemplar.setCodigoDeBarra(codigoDeBarras);

        // Salvando no banco
        return exemplaresRepository.save(exemplar);
    }

    public void deletar(Integer id) {
        ExemplaresRepository.deleteById(id);
    }
}
