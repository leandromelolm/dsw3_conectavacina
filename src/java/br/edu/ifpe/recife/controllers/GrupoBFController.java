/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.Grupo;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author melo
 */

@ManagedBean(name="gController")
@ViewScoped
public class GrupoBFController {
    
    private Grupo cadastro;
    private Grupo selecao;  
    
    @PostConstruct
    public void init(){
        this.cadastro = new Grupo();
        this.selecao = new Grupo();        
    }
    
    public GrupoBFController(){
        this.cadastro = new Grupo();
    }
    
    public String insert(){
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro salvo!",
                        "O " + this.cadastro.getDenominacao()
                        + " foi cadastrado com sucesso!"));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        
        ManagerDao.getCurrentInstance().insert(this.cadastro);        
     
        this.cadastro = new Grupo();
        
        return "profissional_grupos?faces-redirect=true";
    }
    
    public List<Grupo> readAll() {

        String query = "select g from Grupo g";

        return ManagerDao.getCurrentInstance().read(query, Grupo.class);
    }
        
    public void update(){
    
        ManagerDao.getCurrentInstance().update(this.selecao);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("alteração salva! ",
                        "Registro de Id número " +this.getSelecao().getId() + " alterado com sucesso!"));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
    public void delete(){
    
        ManagerDao.getCurrentInstance().delete(this.selecao);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("registro excluido! ",
                        "Registro de Id número " +this.getSelecao().getId() + " deletado com sucesso!"));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
    public String insertAdmin() {

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro salvo!",
                        "O " + this.cadastro.getDenominacao()
                        + " foi cadastrado com sucesso!"));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        
        ManagerDao.getCurrentInstance().insert(this.cadastro);    
        this.cadastro = new Grupo(); 
        
        return "admin_grupos?faces-redirect=true";
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
