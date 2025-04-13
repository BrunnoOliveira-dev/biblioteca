package com.example.biblioteca.repository;

import com.example.biblioteca.entity.Exemplares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemplaresRepository extends JpaRepository<Exemplares, Integer> {
    @Query("SELECT COUNT(e) FROM Exemplares e WHERE e.livro.id_livro = :livroId")
    long countByLivroId(@Param("livroId") int livroId);
}
