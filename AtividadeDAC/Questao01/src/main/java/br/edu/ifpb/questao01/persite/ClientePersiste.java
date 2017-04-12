/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.questao01.persite;

import br.edu.ifpb.questao01.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author laerton
 */
public class ClientePersiste extends GenericPersiste<Cliente>{
    
    public Cliente findByLoginAndSenha(String login, String senha){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAC-PU");
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("Select e from Cliente as e where e.login=:login and e.senha=:senha", Cliente.class);
            q.setParameter("login", login);
            q.setParameter("senha", senha);
            return (Cliente) q.getResultList().get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
        
    }
}
