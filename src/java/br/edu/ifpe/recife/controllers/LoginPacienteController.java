package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.Paciente;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author melo
 */
@ManagedBean(name = "lPacienteController")
@SessionScoped
public class LoginPacienteController implements Serializable{
    
    private Paciente logado;
    private Paciente cadastro;
    
    public String logar(String id, String nome){
        
        try{
            Paciente auxPS = (Paciente)ManagerDao.getCurrentInstance().read(
                    "select p from Paciente p where p.id=\""+id
                            +"\" and p.nome=\""+nome+"\"", Paciente.class).get(0);
            
            this.logado = auxPS;            
                 
            return "paciente_home.xhtml";
          
        }catch(IndexOutOfBoundsException in){
            
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Erro de Autenticação", "id e/ou nome estão incorretos"));
            
            return null;
        }       
    }
    
    public String logout(){
        this.logado=null;
        return "paciente_login.xhtml";
    }

    public Paciente getLogado() {
        return logado;
    }

    public void setLogado(Paciente logado) {
        this.logado = logado;
    }
}
