/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.ProfissionalEnfermagem;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author melo
 */

@ManagedBean
@SessionScoped
public class ProfissionalEnfController {
    
    private ProfissionalEnfermagem cadastro;
    
    @PostConstruct
    public void init(){
        this.cadastro = new ProfissionalEnfermagem();
        
    }
    
    public String insert(){
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "OK","Profissional de saúde "+this.cadastro.getNome()+" cadastrado com sucesso!"));         
        return "index.xhtml";
    }

    public ProfissionalEnfermagem getCadastro() {
        return cadastro;
    }

    public void setCadastro(ProfissionalEnfermagem cadastro) {
        this.cadastro = cadastro;
    }    
    
}
