/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.classes;

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
public class Grupo {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String denominacao;
    private String idadeMinima;
    private String idadeMaxima;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    
    
}
