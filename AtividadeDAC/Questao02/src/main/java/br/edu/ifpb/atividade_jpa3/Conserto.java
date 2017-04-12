/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade_jpa3;

//import com.sun.xml.internal.bind.v2.model.core.MaybeElement;
//import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author laerton
 */
@Entity
public class Conserto implements Serializable{
    
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double valor;
    @Temporal(TemporalType.DATE)
    private LocalDate realizadoEm;
    
    @ManyToOne
    private Funcionario realizadoPor;

    public Conserto() 
    {
    }

    public Conserto(double valor, LocalDate realizadoEm, Funcionario realizadoPor) {
        this.valor = valor;
        this.realizadoEm = realizadoEm;
        this.realizadoPor = realizadoPor;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getRealizadoEm() {
        return realizadoEm;
    }

    public void setRealizadoEm(LocalDate realizadoEm) {
        this.realizadoEm = realizadoEm;
    }

    public Funcionario getRealizadoPor() {
        return realizadoPor;
    }

    public void setRealizadoPor(Funcionario realizadoPor) {
        this.realizadoPor = realizadoPor;
    }

    @Override
    public String toString() {
        return "Conserto{" + "id=" + id + ", valor=" + valor + ", realizadoEm=" + realizadoEm + ", realizadoPor=" + realizadoPor.getNome() + '}';
    }
            
    
}
