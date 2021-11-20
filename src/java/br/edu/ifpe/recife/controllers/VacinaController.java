/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.Vacina;
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
public class VacinaController {
    
    private Vacina cadastro;
    
    @PostConstruct
    public void init(){
        this.cadastro = new Vacina();
    }
    
    public String insert() throws InterruptedException{
    
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        this.cadastro = new Vacina();    
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "OK","Vacina "+this.cadastro.getNome()+" cadastrada com sucesso!")); 
        //new Thread().sleep(40000);
        return "index.xhtml";
    }   

    public Vacina getCadastro() {
        return cadastro;
    }

    public void setCadastro(Vacina cadastro) {
        this.cadastro = cadastro;
    }   
    
}
