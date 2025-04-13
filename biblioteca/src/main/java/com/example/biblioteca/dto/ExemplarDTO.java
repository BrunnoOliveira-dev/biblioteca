package com.example.biblioteca.dto;

public class ExemplarDTO {
    private Integer idLivro;  // id do livro
    private String isbn;      // isbn do livro
    private boolean disponivel;

    public ExemplarDTO() {
        this.disponivel = true;  // Por padrão, o exemplar estará disponível
    }

    // Construtor com idLivro
    public ExemplarDTO(int idLivro) {
        this.idLivro = idLivro;
        this.disponivel = true;
    }

    // Construtor com ISBN
    public ExemplarDTO(String isbn) {
        this.isbn = isbn;
        this.disponivel = true;
    }

    // Getters e Setters
    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
