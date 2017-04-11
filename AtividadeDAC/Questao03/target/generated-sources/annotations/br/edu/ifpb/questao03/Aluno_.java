package br.edu.ifpb.questao03;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-10T22:36:39")
@StaticMetamodel(Aluno.class)
public class Aluno_ extends Pessoa_ {

    public static volatile SingularAttribute<Aluno, String> matricula;
    public static volatile SingularAttribute<Aluno, LocalDate> dataIngresso;
    public static volatile SingularAttribute<Aluno, String> turma;

}