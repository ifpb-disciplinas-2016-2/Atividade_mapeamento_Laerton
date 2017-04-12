
import br.edu.ifpb.questao01.Cliente;
import br.edu.ifpb.questao01.Conta;
import br.edu.ifpb.questao01.ContaType;
import br.edu.ifpb.questao01.Controler.ControlerCliente;
import java.time.LocalDate;
import java.time.Month;
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
public class Principal {
 
    private static Cliente cliente;
    private static Conta conta;
    public static void main(String[] args) {
        criaDados();
        //Logando
        ControlerCliente cc = ControlerCliente.loga("laerton", "12345");
        //Trocando senha
        cc.trocarSenha("12345", "123456");
        //Adicionar conta poupança
        conta = new Conta(1234, 53, 1, 1, "123456", ContaType.POUPANCA);
        cc.adicionaConta(conta);
        cc.deposito(1000);
        cc.saque(500);
        cc.extrato();
        
        //Adiciona conta corrente - tratamento tendo já conta
        Conta c2 = new Conta(6789, 53, 1, 1, "123456", ContaType.CONTACORRENTE);
        cc.adicionaConta(c2);
        //Remover a conta
        cc.removeConta();
        
        //Adiciona conta corrente
        
        cc.adicionaConta(c2);
        cc.deposito(1000);
        cc.saque(500);
        cc.extrato();
       
        
        
    }
    
    
    private static void criaDados()
    {
        cliente = new Cliente();
        cliente.setNome("Laerton");
        cliente.setLogin("laerton");
        cliente.setSenha("12345");
        cliente.setDtnascimento(LocalDate.of(1977, 11, 28));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAC-PU");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }
}
