package com.example.biblioteca.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exemplares")
@Getter
@Setter
public class Exemplares {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_exemplar;

    @Column(name = "status")
    private boolean disponivel = true;

    @ManyToOne
    @JoinColumn(name = "id_livro", nullable = false)
    @JsonBackReference
    private Livro livro;

    @Column(unique = true)
    private String codigoDeBarra;

}
