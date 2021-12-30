/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.classes;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 *
 * @author melo
 */
@Entity
public class Paciente implements Serializable{
    
    @Id
    @Column(name="id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "nome_paciente", length = 50, nullable = false)
    private String nome;
    
    @Column (name = "data_nascimento", nullable = true)    
    @Temporal(TemporalType.DATE)    
    private Date nascimento;
//    private String nascimento;
    
    @Column (name = "caracteristica_individual", nullable = false)
    private String caracteristicasIndividuais; 
    
    @ManyToOne
    @JoinColumn (name = "grupo", nullable = false)
    private Grupo grupo;
    
    // https://www.youtube.com/watch?v=_JPSWt2v008&list=PLcxA6SshISoabC9laeDArv9QVEnw6tzb_&index=9 //Aula 09 - Sistema Times de Futebol - Mapeamento de Coleções – Jogadores na classe Time
    //https://www.youtube.com/watch?v=QYix013uphI&list=PLXEnrSaX5MYCJHrDi2PvETbflH3aC3OOU&index=33 //Web3: aula29, inserindo avaliações
    @OneToMany
    private List<Aplicacoes> dosesrecebidas;
//    private List<Aplicacoes> dosesrecebidas = new ArrayList<>();
    
    public Paciente(){
        this.dosesrecebidas = new ArrayList<>();
    }
    
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
        return dosesrecebidas;
    }

    public void setAplicacao(List<Aplicacoes> dosesrecebidas) {
        this.dosesrecebidas = dosesrecebidas;
    }
    
    
    
}
