/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.Vacina;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import java.util.List;
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
    private Vacina selecao;
    
    @PostConstruct
    public void init(){
        this.cadastro = new Vacina();
    }
    
    public String insert()  {
    
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        this.cadastro = new Vacina();    
//        FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(FacesMessage.SEVERITY_INFO,
//                        "OK","Vacina "+this.cadastro.getNome()+
//                                " cadastrada com sucesso!")); 
//        messageInfo();
        
        return "index.xhtml";
    }
    
    public List<Vacina> readAll(){
    
        String query = "select v from Vacina v";
        
        return ManagerDao.getCurrentInstance().read(query, Vacina.class);
    }

    public Vacina getCadastro() {
        return cadastro;
    }

    public void setCadastro(Vacina cadastro) {
        this.cadastro = cadastro;
    }
    
        public Vacina getSelecao() {
        return selecao;
    }

    public void setSelecao(Vacina selecao) {
        this.selecao = selecao;
    }
    
    public void messageInfo() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Vacina", "Cadastrada com sucesso!"));
//        insert();
//        ManagerDao.getCurrentInstance().insert(this.cadastro);
//        this.cadastro = new Vacina(); 
    }
    
}
