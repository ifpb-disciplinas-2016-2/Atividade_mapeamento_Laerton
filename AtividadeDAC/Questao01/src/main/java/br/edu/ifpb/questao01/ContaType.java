/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.questao01;

/**
 *
 * @author laerton
 */
public enum ContaType {
    POUPANCA(0), CONTACORRENTE(1);
    private final int valor;

    ContaType(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    
}
