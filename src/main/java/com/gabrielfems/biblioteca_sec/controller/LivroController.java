package com.gabrielfems.biblioteca_sec.controller;

import com.gabrielfems.biblioteca_sec.model.Livro;
import com.gabrielfems.biblioteca_sec.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        List<Livro> lista = livroService.obterLivros();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/livros/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        Optional<Livro> encontrado = livroService.obterLivro(id);
        return ResponseEntity.ok().body(encontrado);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        Livro request = livroService.lancaLivro(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/livros/{id}")
    public ResponseEntity<Livro> deleteLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

}
