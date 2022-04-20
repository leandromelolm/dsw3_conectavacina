/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author melo
 */
@Entity
@Table(name = "tb_aplicacao")
public class Aplicacoes implements Serializable{
    
    @Id
    @Column(name="id_aplicacao")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="data_aplicacao")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column (name = "hora")  
    private int hora;
    
    @Column (name = "descricao", length = 200)  
    private String descricao;
    
    @ManyToOne
    @JoinColumn (name = "profissional_id", nullable = true)
    private ProfissionalEnfermagem profissional;    
   
    @ManyToOne
    @JoinColumn (name = "vacina_id", nullable = true)
    private Vacina vacina;   
    
    @ManyToOne
//    @JoinColumn (name = "paciente", referencedColumnName = "id", nullable = true)
    @JoinColumn (name = "paciente_id")
    private Paciente paciente;
    
    public Aplicacoes(){    
//        this.data = new Date();        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ProfissionalEnfermagem getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalEnfermagem profissional) {
        this.profissional = profissional;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
            
}
