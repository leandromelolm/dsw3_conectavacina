/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.classes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author melo
 */
@Entity
public class Paciente{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "nome_paciente", length = 50, nullable = false)
    private String nome;
    @Column
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @Column
    private String caracteristicasIndividuais;    
    @ManyToOne
    @JoinColumn 
    private Grupo grupo;       
    @OneToMany
    @JoinColumn 
    private List<Aplicacoes> aplicacao;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCaracteristicasIndividuais() {
        return caracteristicasIndividuais;
    }

    public void setCaracteristicasIndividuais(String caracteristicasIndividuais) {
        this.caracteristicasIndividuais = caracteristicasIndividuais;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Aplicacoes> getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(List<Aplicacoes> aplicacao) {
        this.aplicacao = aplicacao;
    }
    
    
    
}
