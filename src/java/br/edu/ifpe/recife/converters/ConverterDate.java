package br.edu.ifpe.recife.converters;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author lsmelo
 */
@FacesConverter(value = "converterDate")
public class ConverterDate implements Serializable, Converter{
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            Calendar retorno = Calendar.getInstance();
            Date retornoDate = retorno.getTime();
//            retornoDate.setTime(sdf.parse(string));            
            return retornoDate;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null){
            return null;
        }
        Date obj = (Date) t;
        return sdf.format(obj.getTime());
    }

}