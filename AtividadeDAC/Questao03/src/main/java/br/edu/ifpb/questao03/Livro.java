/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.questao03;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author laerton
 */
@Entity
public class Livro {
    @Id
    private String ISBN;
    
    @ManyToOne(targetEntity = Autor.class)
    @JoinColumn(name = "autorid")
    private Autor autor;
    private String titulo;
    private LocalDate lancamento;

    public Livro(String ISBN, Autor autor, String titulo, LocalDate lancamento) {
        this.ISBN = ISBN;
        this.autor = autor;
        this.titulo = titulo;
        this.lancamento = lancamento;
    }

    public Livro() {
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }
    
    
}
