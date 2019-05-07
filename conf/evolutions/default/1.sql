# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table aluno (
  matricula                     varchar(255) not null,
  nome                          varchar(255),
  data_nasc                     timestamp,
  sexo                          varchar(255),
  curso_codigo                  bigint,
  constraint pk_aluno primary key (matricula)
);

create table aluno_disciplina (
  aluno_matricula               varchar(255) not null,
  disciplina_codigo             bigint not null,
  constraint pk_aluno_disciplina primary key (aluno_matricula,disciplina_codigo)
);

create table curso (
  codigo                        bigint auto_increment not null,
  nome                          varchar(255),
  nivel                         varchar(255),
  constraint pk_curso primary key (codigo)
);

create table disciplina (
  codigo                        bigint auto_increment not null,
  nome                          varchar(255),
  carga_horaria                 integer,
  ementa                        text,
  constraint pk_disciplina primary key (codigo)
);

create index ix_aluno_curso_codigo on aluno (curso_codigo);
alter table aluno add constraint fk_aluno_curso_codigo foreign key (curso_codigo) references curso (codigo) on delete restrict on update restrict;

create index ix_aluno_disciplina_aluno on aluno_disciplina (aluno_matricula);
alter table aluno_disciplina add constraint fk_aluno_disciplina_aluno foreign key (aluno_matricula) references aluno (matricula) on delete restrict on update restrict;

create index ix_aluno_disciplina_disciplina on aluno_disciplina (disciplina_codigo);
alter table aluno_disciplina add constraint fk_aluno_disciplina_disciplina foreign key (disciplina_codigo) references disciplina (codigo) on delete restrict on update restrict;


# --- !Downs

alter table aluno drop constraint if exists fk_aluno_curso_codigo;
drop index if exists ix_aluno_curso_codigo;

alter table aluno_disciplina drop constraint if exists fk_aluno_disciplina_aluno;
drop index if exists ix_aluno_disciplina_aluno;

alter table aluno_disciplina drop constraint if exists fk_aluno_disciplina_disciplina;
drop index if exists ix_aluno_disciplina_disciplina;

drop table if exists aluno;

drop table if exists aluno_disciplina;

drop table if exists curso;

drop table if exists disciplina;

