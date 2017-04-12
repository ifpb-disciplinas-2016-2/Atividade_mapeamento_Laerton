/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade_jpa3;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author laerton
 */
@Entity
public class Funcionario implements Serializable{
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome, cpf, rg;
    private double saalrio;
    
    @Enumerated(EnumType.ORDINAL)
    private FuncaoType funcao;
    

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String rg, double salario, FuncaoType funcao) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.saalrio = salario;
        this.funcao = funcao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public double getSaalrio() {
        return saalrio;
    }

    public void setSaalrio(double saalrio) {
        this.saalrio = saalrio;
    }

    public FuncaoType getFuncao() {
        return funcao;
    }

    public void setFuncao(FuncaoType funcao) {
        this.funcao = funcao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}


