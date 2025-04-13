package com.example.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
@Getter
@Setter
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_emprestimo")
    private Integer idEmprestimo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_exemplar", referencedColumnName = "id_exemplar")
    private Exemplares exemplar;

    @Column(nullable = false)
    private LocalDate data_emprestimo;

    @Column(nullable = false)
    private Integer numero_de_renovacoes = 0;
}
