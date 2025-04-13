package com.example.biblioteca.service;

import com.example.biblioteca.entity.Emprestimo;
import com.example.biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {
    private final EmprestimoRepository EmprestimoRepository;

    public EmprestimoService(EmprestimoRepository EmprestimoRepository) {
        this.EmprestimoRepository = EmprestimoRepository;
    }

    public List<Emprestimo> listarTodos() {
        return EmprestimoRepository.findAll();
    }

    public Emprestimo buscarPorId(Integer id) {
        return EmprestimoRepository.findById(id).orElse(null);
    }

    public Emprestimo salvar(Emprestimo Emprestimo) {
        return EmprestimoRepository.save(Emprestimo);
    }

    public void deletar(Integer id) {
        EmprestimoRepository.deleteById(id);
    }
}
