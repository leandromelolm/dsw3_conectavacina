/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.conectavacina_maven.model.classes;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 *
 * @author melo
 */
@Entity
@Table(name = "tb_paciente")
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
    
    @Column (name = "caracteristica_individual", length = 300, nullable = false)
    private String caracteristicasIndividuais; 
    
    @ManyToOne
    @JoinColumn (name = "grupo", referencedColumnName = "denominacao", nullable = true) // nullable false = erro ao deletar o paciente  Column 'grupo' cannot be null Error Code: 1048 Call: UPDATE PACIENTE SET grupo = ? WHERE (id = ?) bind => [2 parameters bound]
    private Grupo grupo;
        
//    @OneToMany (mappedBy = "paciente")
    @OneToMany (mappedBy = "paciente", cascade = CascadeType.ALL,
           orphanRemoval = true, fetch = FetchType.EAGER)
    //private List<Aplicacoes> dosesrecebidas;
    private List<Aplicacoes> dosesrecebidas = new ArrayList<>();
    
    public Paciente(){
//        this.dosesrecebidas = new ArrayList<>();
    }
    
    public void adicionarDose(Aplicacoes obj){
        obj.setPaciente(this);
        this.dosesrecebidas.add(obj);
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
    
    @Override
    public String toString() {
        return "Paciente{" + "dosesrecebidas=" + dosesrecebidas + '}';
    }
}


// Mapeamento  @OneToMany
// https://www.youtube.com/watch?v=_JPSWt2v008&list=PLcxA6SshISoabC9laeDArv9QVEnw6tzb_&index=9 //Aula 09 - Sistema Times de Futebol - Mapeamento de Coleções – Jogadores na classe Time
//https://www.youtube.com/watch?v=QYix013uphI&list=PLXEnrSaX5MYCJHrDi2PvETbflH3aC3OOU&index=33 //Web3: aula29, inserindo avaliações