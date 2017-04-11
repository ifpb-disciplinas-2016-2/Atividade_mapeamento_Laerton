/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.questao03;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author laerton
 */
@Entity
public class Autor extends Pessoa{
    private String instituicaoVinculada;
    
    @OneToMany(mappedBy = "autor")
    private List<Livro> livros = new LinkedList<Livro>();

    public Autor(String instituicaoVinculada, String cpf, String nome, LocalDate dataNascimento, Endereco endereco) {
        super(cpf, nome, dataNascimento, endereco);
        this.instituicaoVinculada = instituicaoVinculada;
    }

    public Autor() {
    }

    
    private void addLivro (Livro livro){
        livro.setAutor(this);
        livros.add(livro);
    }
    private void removeLivro(Livro livro){
        livros.remove(livro);
    }
    
    public String getInstituicaoVinculada() {
        return instituicaoVinculada;
    }

    public void setInstituicaoVinculada(String instituicaoVinculada) {
        this.instituicaoVinculada = instituicaoVinculada;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
}
