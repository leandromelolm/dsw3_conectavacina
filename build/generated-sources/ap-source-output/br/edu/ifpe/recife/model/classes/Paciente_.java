package br.edu.ifpe.recife.model.classes;

import br.edu.ifpe.recife.model.classes.Aplicacoes;
import br.edu.ifpe.recife.model.classes.Grupo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-02T03:07:16")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, Date> nascimento;
    public static volatile ListAttribute<Paciente, Aplicacoes> dosesrecebidas;
    public static volatile SingularAttribute<Paciente, Grupo> grupo;
    public static volatile SingularAttribute<Paciente, String> nome;
    public static volatile SingularAttribute<Paciente, String> caracteristicasIndividuais;
    public static volatile SingularAttribute<Paciente, Integer> id;

}