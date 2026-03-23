package com.gabrielfems.biblioteca_sec.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tb_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titulos")
    private String titulo;

    @Column(name="autores")
    private String autor;

    private String anoPublicacao;
}
