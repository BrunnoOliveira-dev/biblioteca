package com.example.biblioteca.service;

import com.example.biblioteca.entity.Usuario;
import com.example.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository UsuarioRepository;

    public UsuarioService(UsuarioRepository UsuarioRepository) {
        this.UsuarioRepository = UsuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return UsuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return UsuarioRepository.findById(id).orElse(null);
    }

    public Usuario salvar(Usuario Usuario) {
        return UsuarioRepository.save(Usuario);
    }

    public void deletar(Integer id) {
        UsuarioRepository.deleteById(id);
    }
}
