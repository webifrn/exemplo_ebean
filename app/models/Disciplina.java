package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Disciplina extends Model {

  public Disciplina(String nome, Integer cargaHoraria, String ementa){
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
    this.ementa = ementa;
    this.alunos = new ArrayList<>();
  }

  @Id
  public Long codigo;

  public String nome;

  public Integer cargaHoraria;

  @Column(columnDefinition = "text")
  public String ementa;

  @ManyToMany(mappedBy="disciplinas")
  public List<Aluno> alunos;

  public static final Finder<Long, Disciplina> find = new Finder<>(Disciplina.class);
}
