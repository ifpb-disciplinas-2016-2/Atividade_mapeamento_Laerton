package br.edu.ifpb.atividade_jpa3;



import br.edu.ifpb.aividade_jpa3.DAO.DaoConserto;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laerton
 */
public class Prinicpal {
    
    public static void main(String[] args) {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_teste");
        //ConsertoJpaController dao = new ConsertoJpaController(emf);
        
        DaoConserto dao = new DaoConserto();
        Funcionario f = CriaDados();
        Conserto c = new Conserto(100, LocalDate.now(), f);
        dao.create(c);
        System.out.println(c);
        //dao.destroy(c.getId());
        //dao.destroy(c.getId());
        
    }
    private static Funcionario CriaDados(){
        
        Oficina oficina = new Oficina(new Endereco("A", "B", "C", "PB", "58800-280", 10), "OficinaLaerton", 10000);
        Funcionario f = new Funcionario("LAERTON MARQUES DE FIGUEIREDO", "000.000.000-00", "000000", 1000, FuncaoType.EMPREGADO);
        oficina.addFuncionario(f);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_teste");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(f);
        em.persist(oficina);
        em.getTransaction().commit();
        return f;
    }
    
}
