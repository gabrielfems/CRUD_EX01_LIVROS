package com.gabrielfems.biblioteca_sec.repository;

import com.gabrielfems.biblioteca_sec.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findById(Long id);
}
