package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Curso extends Model {

  public Curso(String nome, String nivel){
    this.nome = nome;
    this.nivel = nivel;
    this.alunos = new ArrayList<>();
  }

  @Id
  public Long codigo;

  public String nome;

  public String nivel;

  @OneToMany(mappedBy="curso")
  public List<Aluno> alunos;

  public static final Finder<Long, Curso> find = new Finder<>(Curso.class);
}
