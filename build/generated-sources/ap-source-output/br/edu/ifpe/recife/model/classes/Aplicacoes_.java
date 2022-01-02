package br.edu.ifpe.recife.model.classes;

import br.edu.ifpe.recife.model.classes.Paciente;
import br.edu.ifpe.recife.model.classes.ProfissionalEnfermagem;
import br.edu.ifpe.recife.model.classes.Vacina;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-02T03:07:16")
@StaticMetamodel(Aplicacoes.class)
public class Aplicacoes_ { 

    public static volatile SingularAttribute<Aplicacoes, Date> data;
    public static volatile SingularAttribute<Aplicacoes, Vacina> vacina;
    public static volatile SingularAttribute<Aplicacoes, Integer> hora;
    public static volatile SingularAttribute<Aplicacoes, Paciente> paciente;
    public static volatile SingularAttribute<Aplicacoes, Integer> id;
    public static volatile SingularAttribute<Aplicacoes, ProfissionalEnfermagem> profissional;
    public static volatile SingularAttribute<Aplicacoes, String> descricao;

}