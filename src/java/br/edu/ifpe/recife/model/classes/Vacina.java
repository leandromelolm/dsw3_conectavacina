/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.classes;

import com.sun.istack.internal.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author melo
 */
@Entity
public class Vacina {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nome_vacina", length = 20, nullable = false)
    @NotNull
    private String nome;
    @Column(length = 20, nullable = false)
    @NotNull
    private String fabricante;
    @Column(length = 3, nullable = false)
    @NotNull
    private String tempoEntreAplicacoes;
    @Column(length = 3, nullable = false)
    @NotNull
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
