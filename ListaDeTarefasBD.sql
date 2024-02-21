-- Active: 1705366472878@@127.0.0.1@3306@listadetarefas

USE listadetarefas;

CREATE TABLE tarefas(
    id int not null auto_increment,
    descricao varchar(500),
    prioridade int not null,
    status int not null,
    dataConclusao date,
    PRIMARY KEY(id)
);
