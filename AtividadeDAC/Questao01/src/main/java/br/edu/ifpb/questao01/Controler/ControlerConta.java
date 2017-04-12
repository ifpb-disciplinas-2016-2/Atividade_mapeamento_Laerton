/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.questao01.Controler;

import br.edu.ifpb.questao01.Cliente;
import br.edu.ifpb.questao01.Conta;
import br.edu.ifpb.questao01.ContaType;
import br.edu.ifpb.questao01.LancamentoType;
import br.edu.ifpb.questao01.Movimento;
import br.edu.ifpb.questao01.persite.GenericPersiste;
import java.util.Iterator;


/**
 *
 * @author laerton
 */
public class ControlerConta {
    private Conta conta;
    private GenericPersiste<Conta> pc = new GenericPersiste<>();
    private GenericPersiste<Movimento> pm = new GenericPersiste<>();
    
    public ControlerConta(Conta conta) {
        this.conta = conta;
    }
    
    public void removeConta(){
        pc.destroy(Conta.class, conta.getCodigo());
        this.conta = null;
    }
    
    public static ControlerConta criaConta(Conta conta){
        GenericPersiste<Conta> pc = new GenericPersiste<>();
        return new ControlerConta(pc.create(conta));
    }
    
    public void alteraSenhaConta(String senhaAtual, String novaSenha){
        if (this.conta.getSenha().equals(senhaAtual)){
            this.conta.setSenha(novaSenha);
            salva();
            System.out.println("Senha alterada co sucesso!");
        }else{
            System.out.println("Senha incorreta!");
        }
    }
    
    public boolean validaSenha(String senha){
        return conta.getSenha().equals(senha);
    }
    
    public void salva (){
        pc.edit(conta);
    }
    
    public void saque(double  valor){
        Movimento m = new Movimento(conta, LancamentoType.DEBITO, valor);
        conta.addMovimento(m);
        if(conta.getTipo()==ContaType.CONTACORRENTE){
            Movimento m2 = new Movimento(conta, LancamentoType.DEBITO, 0.75);
            conta.addMovimento(m2);
        }
        this.salva();
    }
    
    public void deposito (double valor){
        Movimento m = new Movimento(conta, LancamentoType.CREDITO, valor);
        conta.addMovimento(m);
        if (conta.getTipo() ==ContaType.POUPANCA){
            Movimento m2 = new Movimento(conta, LancamentoType.CREDITO, 0.56);
            conta.addMovimento(m2);
        }
        this.salva();
    }
    
    public void extrato(){
        double saldo = 0;
        System.err.println("Extrato da conta: " + this.conta.getNumero() + "-" + this.conta.getDvconta() + " Tipo de conta: " + 
                this.conta.getTipo());
        for (Movimento movimento : conta.getMovimentos()) {
            System.out.println("Tipo: "+ movimento.getTipo() + " R$ " + movimento.getValor());
            saldo += (movimento.getTipo()== LancamentoType.DEBITO)? (movimento.getValor() *-1): movimento.getValor();
            
        }
        System.err.println("Saldo da conta: R$ " + saldo);
    }
    
   
    
    
}
