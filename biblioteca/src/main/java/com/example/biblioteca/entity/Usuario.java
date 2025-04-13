package com.example.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_usuario;

    @Column(nullable = false, length = 11, unique = true)
    public String senha;

    @Column(name = "CPF", columnDefinition = "CHAR(11)")
    public String CPF;



}
