package com.gabrielfems.biblioteca_sec.service;

import com.gabrielfems.biblioteca_sec.model.Livro;
import com.gabrielfems.biblioteca_sec.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro lancaLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> obterLivros (){
        return livroRepository.findAll();
    }

    public Optional<Livro> obterLivro(Long id) {
        return livroRepository.findById(id);
        }

    public void deletarLivro(Long id) { livroRepository.deleteById(id); }
}
