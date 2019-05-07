package controllers;

import play.mvc.*;
import models.*;
import java.util.*;

public class HomeController extends Controller {

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result popular(){
      // Cursos
      Curso curso1 = new Curso("TADS", "Superior");
      curso1.save();
      Curso curso2 = new Curso("TRC", "Superior");
      curso2.save();
      Curso curso3 = new Curso("TII", "Tecnico");
      curso3.save();
      Curso curso4 = new Curso("TMC", "Tecnico");
      curso4.save();
      // Alunos
      Aluno aluno1 = new Aluno("20181001", "Joao", new Date(), "M");
      aluno1.curso = curso1;
      aluno1.save();
      Aluno aluno2 = new Aluno("20181002", "Maria", new Date(), "F");
      aluno2.curso = curso1;
      aluno2.save();
      Aluno aluno3 = new Aluno("20181003", "Ana", new Date(), "F");
      aluno3.curso = curso3;
      aluno3.save();
      Aluno aluno4 = new Aluno("20181004", "Jose", new Date(), "M");
      aluno4.curso = curso3;
      aluno4.save();
      Aluno aluno5 = new Aluno("20181005", "Ruth", new Date(), "F");
      aluno5.curso = curso4;
      aluno5.save();

      // Disciplinas
      Disciplina disc1 = new Disciplina("Programacao", 90, "");
      disc1.alunos.add(aluno1);
      disc1.alunos.add(aluno2);
      disc1.save();

      Disciplina disc2 = new Disciplina("Matematica", 60, "");
      disc2.alunos.add(aluno3);
      disc2.alunos.add(aluno4);
      disc2.save();

      Disciplina disc3 = new Disciplina("Fisica", 60, "");
      disc3.alunos.add(aluno3);
      disc3.alunos.add(aluno4);
      disc3.save();

      return ok("Banco de Dados populado.");
    }

    public Result cursos() {
        List<Curso> cursos = Curso.find.query().select("*").findList();
        return ok(views.html.cursos.render(cursos));
    }

    public Result alunos() {
        List<Curso> cursos = Curso.find.query()
          .select("*").fetch("alunos", "nome").findList();
        return ok(views.html.alunos.render(cursos));
    }

    public Result aluno(String matricula){
      Aluno aluno = Aluno.find.query()
        .select("*").fetch("curso", "nome").where().idEq(matricula).findOne();
        return ok(views.html.aluno.render(aluno));
    }

    public Result disciplinasAlunas(){
      List<Disciplina> disciplinas = Disciplina.find.query()
        .select("*")
        .where()
        .filterMany("alunos").eq("sexo", "F")
        .findList();
        return ok(views.html.disciplinas.render(disciplinas));
    }

}
