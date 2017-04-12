/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.questao01;

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
public class Movimento {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Conta conta;
    @Enumerated(EnumType.STRING)
    private LancamentoType tipo;
    private double valor;

    public Movimento( Conta conta, LancamentoType tipo, double valor) {
        
        this.conta = conta;
        this.tipo = tipo;
        this.valor = valor;
    }

    
    public Movimento() {
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public LancamentoType getTipo() {
        return tipo;
    }

    public void setTipo(LancamentoType tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
