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
public class Professor extends Pessoa{
    private double salario;
    
    @OneToMany
    private List<Telefone> telefones = new LinkedList<Telefone>();

    public Professor(double salario, String cpf, String nome, LocalDate dataNascimento, Endereco endereco) {
        super(cpf, nome, dataNascimento, endereco);
        this.salario = salario;
    }

    public Professor() {
    }
    
    public void addTelefone (Telefone tele){
        telefones.add(tele);
    }
    
    public void remTelefone(Telefone tele){
        telefones.remove(tele);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
}
