/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author melo
 */
@Entity
@Table(name = "tb_vacina")
public class Vacina implements Serializable {
    
    @Id
    @Column(name="id_vacina")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nome", length = 20, nullable = false)    
    private String nome;
    
    @Column(name="fabricante", length = 20, nullable = false)    
    private String fabricante;
    
    @Column(name="tempo_entre_aplicacoes", length = 3, nullable = false)    
    private String tempoEntreAplicacoes;
    
    @Column(name="quant_doses", length = 3, nullable = false)    
    private Integer quantidadeAplicacoes;

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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTempoEntreAplicacoes() {
        return tempoEntreAplicacoes;
    }

    public void setTempoEntreAplicacoes(String tempoEntreAplicacoes) {
        this.tempoEntreAplicacoes = tempoEntreAplicacoes;
    }

    public Integer getQuantidadeAplicacoes() {
        return quantidadeAplicacoes;
    }

    public void setQuantidadeAplicacoes(Integer quantidadeAplicacoes) {
        this.quantidadeAplicacoes = quantidadeAplicacoes;
    }
    
    
    
}
