/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.aividade_jpa3.DAO;

import br.edu.ifpb.atividade_jpa3.Conserto;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author laerton
 */
public class DaoConserto implements Serializable{
   
    
    public DaoConserto(){
        
       
    }
   
    public Conserto create(Conserto obj) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_teste");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.persist(obj);
         em.getTransaction().commit();
         em.close();
         return obj;
    }

   
    public void edit( Conserto obj) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_teste");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
    }



    public void destroy(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_teste");
        Conserto f = null;
        try {
            f = this.findEntity(id);
        } catch (Exception ex) {
            Logger.getLogger(DaoConserto.class.getName()).log(Level.SEVERE, null, ex);
        }
        EntityManager em = emf.createEntityManager();
        f = em.getReference(Conserto.class, f.getId());
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
        em.close();
    }

    public Conserto findEntity( int id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_teste");
        EntityManager em = emf.createEntityManager();
        Conserto find = em.find(Conserto.class, id);
        if (find == null){
            throw new Exception("Dados não localizados");
        }
        em.close();
        return find;

    }

    public List<Conserto> findEntities() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_teste");
        EntityManager em = emf.createEntityManager();
        Query resposta;
        resposta = em.createQuery("Select e from Conserto as e", Conserto.class);
        em.close();
        return resposta.getResultList();
    }

}

