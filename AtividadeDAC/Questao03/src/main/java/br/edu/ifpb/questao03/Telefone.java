/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.questao03;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 *
 * @author laerton
 */
@Entity
public class Telefone {
    @Id
    private String numero;
    @Enumerated(EnumType.STRING)
    private TelefoneType tipo;

    public Telefone() {
    }

    public Telefone(String numero, TelefoneType tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneType getTipo() {
        return tipo;
    }

    public void setTipo(TelefoneType tipo) {
        this.tipo = tipo;
    }
    
}
