/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.questao01;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author laerton
 */
@Entity
public class Conta implements Serializable{
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private long numero, agencia, dvconta, dvagencia;
    private double saldo;
    private String senha;
    
    @Enumerated(EnumType.STRING)
    private ContaType tipo;
    
    @OneToMany
    private List<Movimento> movimentos = new LinkedList<Movimento>();
    
    public Conta() {
    }

    
    public void addMovimento (Movimento mov){
        mov.setConta(this);
        movimentos.add(mov);
    }
    
    public void remMovimento(Movimento mov){
        movimentos.remove(mov);
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public long getAgencia() {
        return agencia;
    }

    public void setAgencia(long agencia) {
        this.agencia = agencia;
    }

    public long getDvconta() {
        return dvconta;
    }

    public void setDvconta(long dvconta) {
        this.dvconta = dvconta;
    }

    public long getDvagencia() {
        return dvagencia;
    }

    public void setDvagencia(long dvagencia) {
        this.dvagencia = dvagencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ContaType getTipo() {
        return tipo;
    }

    public void setTipo(ContaType tipo) {
        this.tipo = tipo;
    }
    
        
}
