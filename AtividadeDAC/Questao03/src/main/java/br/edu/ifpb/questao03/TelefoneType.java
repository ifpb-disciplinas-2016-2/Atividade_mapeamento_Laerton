/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.questao03;

/**
 *
 * @author laerton
 */
public enum TelefoneType {
 RESIDENCIAL(0), COMERCIAL(1);
 private final int valor;

    TelefoneType(int valor) {
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
 
}
