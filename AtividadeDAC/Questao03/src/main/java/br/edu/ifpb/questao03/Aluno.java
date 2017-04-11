/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.questao03;

import java.time.LocalDate;
import javax.persistence.Entity;

/**
 *
 * @author laerton
 */
@Entity
public class Aluno extends Pessoa{
    private String matricula, turma;
    private LocalDate dataIngresso;

    public Aluno(String matricula, String turma, LocalDate dataIngresso, String cpf, String nome, LocalDate dataNascimento, Endereco endereco) {
        super(cpf, nome, dataNascimento, endereco);
        this.matricula = matricula;
        this.turma = turma;
        this.dataIngresso = dataIngresso;
    }

    public Aluno() {
    }

    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
    
}
