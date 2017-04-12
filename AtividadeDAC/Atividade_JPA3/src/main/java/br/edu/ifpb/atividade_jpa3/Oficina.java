/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade_jpa3;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author laerton
 */
@Entity
public class Oficina implements Serializable{
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Embedded
    private Endereco localizacao;
    private String descricao;
    private double saldo;
 
    @OneToMany()
    private List<Funcionario> funcionarios = new LinkedList<>();
    
    
    public Oficina() 
    {
        
    }

    public Oficina(Endereco localizacao, String descricao, double saldo) {
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.saldo = saldo;
        
    }
    
    public void addFuncionario(Funcionario f){
        funcionarios.add(f);
    }

    public void removeFuncionario(Funcionario f){
        funcionarios.remove(f);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Endereco getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Endereco localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
}
