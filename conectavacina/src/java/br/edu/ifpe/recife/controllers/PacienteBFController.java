package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.Grupo;
import br.edu.ifpe.recife.model.classes.Paciente;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import java.io.Serializable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author leandro melo
 */

@ManagedBean(name="pacController")
@SessionScoped
@ViewScoped
public class PacienteBFController implements Serializable{
    
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
        Date date = sdf.parse(stringnascimento);
        System.out.print(date);
        
        Paciente p = new Paciente();

        p.setNascimento(date);
        p.setNome(nome);       
        p.setCaracteristicasIndividuais(caracteristicasIndividuais);
        p.setGrupo(this.selecaoGrupo);
        
        ManagerDao.getCurrentInstance().insert(p);   
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente salvo!",
                        "Paciente cadastrado com sucesso!"));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        
        
//        return "ps_homeprofissional.xhtml";
        return "profissional_pacientes?faces-redirect=true";
    }
    
    public String insertPaginaPaciente(String nome, String stringnascimento, String caracteristicasIndividuais) throws ParseException  {
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy", Locale.US);   
        Date date = sdf.parse(stringnascimento);
        System.out.print(date);
        
        Paciente p = new Paciente();

        p.setNascimento(date);
        p.setNome(nome);       
        p.setCaracteristicasIndividuais(caracteristicasIndividuais);
        p.setGrupo(this.selecaoGrupo);
        
        ManagerDao.getCurrentInstance().insert(p);   
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo!",
                        "Cadastro realizado com sucesso!"));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso!",
                       p.getNome() + " guarde Seu Identificador: " + p.getId()));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        
        return "paciente_login?faces-redirect=true";

    }
    
    public void insert(String confirma){        
        
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        
        this.cadastro = new Paciente();        
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro salvo!",
                        "Paciente cadastrado com sucesso!")); 
        
    }
    
    public String insertRedirect(String nome, String stringnascimento, String caracteristicasIndividuais) throws ParseException  {
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy", Locale.US);   
        Date date = sdf.parse(stringnascimento);
        System.out.print(date);
        
        Paciente p = new Paciente();

        p.setNascimento(date);
        p.setNome(nome);       
        p.setCaracteristicasIndividuais(caracteristicasIndividuais);
        p.setGrupo(this.selecaoGrupo);
        
        ManagerDao.getCurrentInstance().insert(p);   
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente salvo!",
                        "Paciente cadastrado com sucesso!"));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
//        return "jsf-bf-pacientes.xhtml";
        return "admin_pacientes?faces-redirect=true";
    }
    
    public List<Paciente> readAll(){
        
        String query = "select p from Paciente p";
        
        return ManagerDao.getCurrentInstance().read(query, Paciente.class);    
    }
    
    public void update(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy", Locale.US); 
    
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
