package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.ProfissionalEnfermagem;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author melo
 */
@ManagedBean(name = "lController")
@SessionScoped
public class LoginController {
    
    private ProfissionalEnfermagem logado;
    
    public String logar(String email, String senha){
        
        try{
            ProfissionalEnfermagem auxPS = (ProfissionalEnfermagem)ManagerDao.getCurrentInstance().read(
                    "select ps from ProfissionalEnfermagem ps where ps.email=\""+email
                            +"\" and ps.senha=\""+senha+"\"", ProfissionalEnfermagem.class).get(0);
            
            this.logado = auxPS;
            
            if(email.equals("admin")){
                return "admin_home.xhtml";
            }
            
            return "ps_homeprofissional.xhtml";
            
        }catch(IndexOutOfBoundsException in){
            
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Erro de Autenticação", "emai e/ou senha estão incorretos"));
            
            return null;
        }       
    }
    
    public String logout(){
        this.logado=null;
        return "ps_loginprofissional.xhtml";
    }

    public ProfissionalEnfermagem getLogado() {
        return logado;
    }

    public void setLogado(ProfissionalEnfermagem logado) {
        this.logado = logado;
    }
}
