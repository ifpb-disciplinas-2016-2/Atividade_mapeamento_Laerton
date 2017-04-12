/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade_jpa3;

/**
 *
 * @author laerton
 */
enum FuncaoType{
    EMPREGADO(0), GERENTE(1) ;
    private final int valor;

    private FuncaoType(int valor) {
        this.valor = valor;
    }
    
    public int getValor(){
        return this.valor;
    }
}