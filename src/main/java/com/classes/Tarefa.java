package com.classes;

import java.util.Date;

public class Tarefa {
    private int id;
    private String descricao;
    private int prioridade;
    private int status;
    private Date dataConclusao;

    public int getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public int getStatus() {
        return status;
    }
    public Date getDataConclusao() {
        return dataConclusao;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    

    
}
