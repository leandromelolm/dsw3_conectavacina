/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author melo
 */
@Entity
public class Grupo implements Serializable {
    
    @Id
    @Column(name="id_grupo")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column ( length = 150, nullable = false)
    
    private String denominacao;  
    @Column ( length = 3, nullable = false)
    
    private String idadeMinima;        
    @Column ( length = 3, nullable = false)
        
    private String idadeMaxima;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    public String getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(String idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public String getIdadeMaxima() {
        return idadeMaxima;
    }

    public void setIdadeMaxima(String idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }
    
    @Override
    public String toString() {
        return  denominacao;
    }
    
}
