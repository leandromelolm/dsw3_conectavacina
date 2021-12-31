package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.Aplicacoes;
import br.edu.ifpe.recife.model.classes.Paciente;
import br.edu.ifpe.recife.model.classes.ProfissionalEnfermagem;
import br.edu.ifpe.recife.model.classes.Vacina;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lmelo
 */
@ManagedBean(name="avController")
@ViewScoped
public class AplicacaoVacinaController {
    
    private Aplicacoes register;
    private Aplicacoes select;
    
    private ProfissionalEnfermagem selectProfissional;
    private Vacina selectVacina;
    private Paciente selectPaciente;
    
    public AplicacaoVacinaController(){
        this.register = new Aplicacoes();
    }
    
    @PostConstruct
    public void init(){
        this.register = new Aplicacoes();
        this.select= new Aplicacoes();   
    }
    
    public String insert(String txtDataAplicacao, String txtHora, String descricao) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy", Locale.US);
        Date dataVacina = sdf.parse(txtDataAplicacao);   
        
        int iHora = Integer.parseInt(txtHora.replaceAll("[^0-9]+", ""));
        
        Aplicacoes a = new Aplicacoes();        
        
        a.setData(dataVacina);
        a.setHora(iHora);
        a.setDescricao(descricao);
        a.setVacina(this.selectVacina);
        a.setPaciente(selectPaciente);
        
        loginController login = (loginController)((HttpSession)FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("lController");
        
        ProfissionalEnfermagem pe = login.getLogado();
        
        a.setProfissional(pe);
        
        ManagerDao.getCurrentInstance().insert(a);   
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Vacinação Registrada com sucesso! ",
                        selectPaciente.getNome() +" teve a vacina " +this.selectVacina.getNome() + " registrada com sucesso!")); 
        return "bf-registrosvacina.xhtml";
    }
    
    public List<Aplicacoes> readAll(){
        
        String query = "select a from Aplicacoes a";
        
        return ManagerDao.getCurrentInstance().read(query, Aplicacoes.class);    
    }

    public Aplicacoes getRegister() {
        return register;
    }

    public void setRegister(Aplicacoes register) {
        this.register = register;
    }

    public Aplicacoes getSelect() {
        return select;
    }

    public void setSelect(Aplicacoes select) {
        this.select = select;
    }

    public ProfissionalEnfermagem getSelectProfissional() {
        return selectProfissional;
    }

    public void setSelectProfissional(ProfissionalEnfermagem selectProfissional) {
        this.selectProfissional = selectProfissional;
    }

    public Vacina getSelectVacina() {
        return selectVacina;
    }

    public void setSelectVacina(Vacina selectVacina) {
        this.selectVacina = selectVacina;
    }

    public Paciente getSelectPaciente() {
        return selectPaciente;
    }

    public void setSelectPaciente(Paciente selectPaciente) {
        this.selectPaciente = selectPaciente;
    }
    
}
