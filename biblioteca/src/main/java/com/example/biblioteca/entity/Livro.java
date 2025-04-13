package com.example.biblioteca.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "livro")
@Getter
@Setter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_livro;

    @Column(nullable = false, length = 255)
    private String titulo;

    private String autor;

    private String editora;

    @Column(name = "data_publicacao", nullable = false)
    private Date data_publicacao;

    @Temporal(TemporalType.DATE)
    private Date dataAquisicao;

    @Column(nullable = false, length = 13, unique = true)
    private String ISBN;

    @Column(length = 500)
    private String descricao;

    @Column(length = 255)
    private String imagem;


    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Exemplares> exemplares;
}
