/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.questao01.Controler;

import br.edu.ifpb.questao01.Cliente;
import br.edu.ifpb.questao01.persite.GenericPersiste;

/**
 *
 * @author laerton
 */
public class ControlerCliente {
   private Cliente cliente;
   private GenericPersiste<Cliente> PersistClienten = new  GenericPersiste<>();
   
   public void CadastraCliente(){
       PersistClienten.create(cliente);
   }
   
   public void RemoveCliente(){
       PersistClienten.destroy(Cliente.class, cliente.getCodigo());
   }
   
   public Cliente BuscaCliente(Long codigo) throws Exception{
       return PersistClienten.findEntity(Cliente.class, codigo);
   }
}
