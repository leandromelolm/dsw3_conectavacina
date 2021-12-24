package br.edu.ifpe.recife.converters;

import br.edu.ifpe.recife.model.classes.Grupo;
import java.io.Serializable;
import javax.faces.bean.RequestScoped;
//import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
//import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author melo
 */
//@Named(value = "converterPessoa")
@FacesConverter(value = "converterCalendar")
@RequestScoped
public class ConverterGrupo implements Serializable, Converter {

    @PersistenceContext(unitName = "ConectaVacinaPU")
    protected EntityManager em;    
    
    // converte da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Grupo.class, Integer.parseInt(string));
    }

    // converte do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null){
            return null;
        }
        Grupo obj = (Grupo) t;
        return obj.getId().toString();
    }

}

