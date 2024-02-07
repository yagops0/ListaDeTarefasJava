package com.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.classes.Tarefa;
import com.conexao.Conexao;

public class TarefaDAO 
{
    public void cadastrarTarefa(Tarefa tarefa)
    {
        String sql = "INSERT INTO tarefas(descricao, prioridade, status, dataConclusao) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try
        {
            ps = Conexao.getConexao().prepareStatement(sql);

            //ps.setInt(1, tarefa.getId());
            ps.setString(1, tarefa.getDescricao());
            ps.setInt(2, tarefa.getPrioridade());
            ps.setInt(3, tarefa.getStatus());
            ps.setDate(4, new java.sql.Date(tarefa.getDataConclusao().getTime()));

            ps.execute();

            ps.close();
           
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
