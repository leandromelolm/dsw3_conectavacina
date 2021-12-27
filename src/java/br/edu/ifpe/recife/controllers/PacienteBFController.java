/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.Grupo;
import br.edu.ifpe.recife.model.classes.Paciente;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author lmelo
 */

@ManagedBean(name="pacController")
@SessionScoped
@ViewScoped
public class PacienteBFController {
    
    private Paciente cadastro;
    private Paciente selecao;
    
    private Grupo selecaoGrupo;
    
    public PacienteBFController(){
        this.cadastro = new Paciente();
    }
    
    @PostConstruct
    public void init(){
        this.cadastro = new Paciente();
        this.selecao = new Paciente();   
    }
    
    public String insert(String nome, String stringnascimento, String caracteristicasIndividuais) throws ParseException  {
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy", Locale.US);       
        
        Paciente p = new Paciente();
        
        Date date = sdf.parse(stringnascimento);
        System.out.print(date);

        p.setNascimento(date);
        p.setNome(nome);       
        p.setCaracteristicasIndividuais(caracteristicasIndividuais);
        p.setGrupo(this.selecaoGrupo);
        
        ManagerDao.getCurrentInstance().insert(p);        
              
        
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente salvo!",
                        "Paciente cadastrado com sucesso!")); 
        return "bf-homeprofissional.xhtml";
    }
    
    public void insert(String confirma){        
        
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        
        this.cadastro = new Paciente();        
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro salvo!",
                        "Paciente cadastrado com sucesso!")); 
    }
    
    public List<Paciente> readAll(){
        
        String query = "select p from Paciente p";
        
        return ManagerDao.getCurrentInstance().read(query, Paciente.class);    
    }
    
    public void update(){
    
        ManagerDao.getCurrentInstance().update(this.selecao);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("alteração salva! ",
                        "Registro "+this.selecao.getId() + " alterado com sucesso."));    
    }
    
    public void delete(){
    
        ManagerDao.getCurrentInstance().delete(this.selecao);
      
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("registro excluido! ",
                        "Registro de Id número " +this.getSelecao().getId() + " deletado com sucesso!"));        
    }

    public Paciente getCadastro() {
        return cadastro;
    }

    public void setCadastro(Paciente cadastro) {
        this.cadastro = cadastro;
    }

    public Paciente getSelecao() {
        return selecao;
    }

    public void setSelecao(Paciente selecao) {
        this.selecao = selecao;
    }  
    
    public Grupo getSelecaoGrupo() {
        return selecaoGrupo;
    }

    public void setSelecaoGrupo(Grupo selecaoGrupo) {
        this.selecaoGrupo = selecaoGrupo;
    }

}
