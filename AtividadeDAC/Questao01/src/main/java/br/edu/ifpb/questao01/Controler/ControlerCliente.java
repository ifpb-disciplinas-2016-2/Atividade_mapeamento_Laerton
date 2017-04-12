/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.questao01.Controler;

import br.edu.ifpb.questao01.Cliente;
import br.edu.ifpb.questao01.Conta;
import br.edu.ifpb.questao01.persite.ClientePersiste;
import br.edu.ifpb.questao01.persite.GenericPersiste;

/**
 *
 * @author laerton
 */
public class ControlerCliente {
   private Cliente cliente;
   private GenericPersiste<Cliente> persistclienten = new  GenericPersiste<>();
   private ControlerConta cc;
   
   public ControlerCliente(Cliente cliente) {
        this.cliente = cliente;
        if (cliente.getConta() != null){
            cc = new ControlerConta(this.cliente.getConta());
        }
        
   }
   
   public void CadastraCliente(Cliente client){
       persistclienten.create(client);
   }
   
   public static ControlerCliente loga(String login, String senha){
       Cliente c = null;
       ClientePersiste pc = new ClientePersiste();
       try {
           c = pc.findByLoginAndSenha(login, senha);
       } catch (Exception e) {
           System.err.println("Login ou senha inválida.");
       }
       ControlerCliente controler = new ControlerCliente(c);
       System.err.println("Login realizado com sucesso!");
       return controler;
   }
   
   public void removeCliente(){
       persistclienten.destroy(Cliente.class, cliente.getCodigo());
       this.cliente = null;
   }
   
   public Cliente buscaCliente(Long codigo) throws Exception{
       return persistclienten.findEntity(Cliente.class, codigo);
   }
   
   public void adicionaConta(Conta conta){
       if (this.cliente.getConta() != null){
           System.out.println("Cliente já contém uma conta cadastrada!");
       }else{
           this.cliente.setConta(conta);
           cc = ControlerConta.criaConta(conta);
           salva();
       }
   }
   
   public void removeConta(){
     if(cliente.getConta() == null)  {
         System.out.println("Cliente não tem conta vinculada!");
     }else{
         //Conta c = this.cliente.getConta();
         cliente.setConta(null);
         salva();
         try {
             
             cc.removeConta();
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         
         cc = null;
         
     }
   }
   
   public void trocarSenha(String senhaAtual, String novaSenha){
       if (cliente.getSenha().equals(senhaAtual)){
           cliente.setSenha(novaSenha);
           salva();
       }else{
           System.err.println("Senha inválida!");
       }
       
   }

   public Cliente getCliente() {
        return cliente;
   }

   public void setCliente(Cliente cliente) {
        this.cliente = cliente;
   }
   
   public void saque(double valor)   {
       cc.saque(valor);
   }
   
   public void deposito (double valor){
       cc.deposito(valor);
   }
   
   public void extrato (){
       System.out.println("Cliente: " + cliente.getNome());
       cc.extrato();
   }
   
   public void salva(){
       persistclienten.edit(cliente);
   }
}
