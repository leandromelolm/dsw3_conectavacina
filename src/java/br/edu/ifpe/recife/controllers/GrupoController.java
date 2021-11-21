/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.Grupo;
import br.edu.ifpe.recife.model.classes.ProfissionalEnfermagem;
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
public class GrupoController {
    
    private Grupo cadastro;
    private Grupo selecao;
    
    @PostConstruct
    public void init(){
        this.cadastro = new Grupo();
        
    }
    
    public String insert(){
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.
                        SEVERITY_INFO, "OK","Grupo"+
                                this.cadastro.getDenominacao()+
                                " foi cadastrado com sucesso!"));         
        return "index.xhtml";
    }
    
//    public List<Grupo> readAll(){
//        
//        String query = "select g from Grupo g";
//        
//        return ManagerDao.getCurrentInstance().read(query, Grupo.class);
//    }
    
        public List<Grupo> readAll(){
        
        String query = "select p from Grupo p";
        
        return ManagerDao.getCurrentInstance().read(query, Grupo.class);    
    }

    public Grupo getCadastro() {
        return cadastro;
    }

    public void setCadastro(Grupo cadastro) {
        this.cadastro = cadastro;
    }

    public Grupo getSelecao() {
        return selecao;
    }

    public void setSelecao(Grupo selecao) {
        this.selecao = selecao;
    }

    
    
}
