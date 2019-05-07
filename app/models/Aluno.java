package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Aluno extends Model {

  public Aluno(String matricula, String nome, Date dataNasc, String sexo){
    this.matricula = matricula;
    this.nome = nome;
    this.dataNasc = dataNasc;
    this.sexo = sexo;
    this.disciplinas = new ArrayList<>();
  }

  @Id
  public String matricula;

  public String nome;

  public Date dataNasc;

  public String sexo;

  @ManyToOne
  public Curso curso;

  @ManyToMany
  public List<Disciplina> disciplinas;

  public static final Finder<String, Aluno> find = new Finder<>(Aluno.class);
}
