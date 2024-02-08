package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public void atualizarTarefas(Tarefa tarefa)
    {
        String sql = "UPDATE tarefas SET descricao = ?, prioridade = ?, status = ?, dataConclusao = ? WHERE id = ?";

        PreparedStatement ps = null;

        try 
        {
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, tarefa.getDescricao());
            ps.setInt(2, tarefa.getPrioridade());
            ps.setInt(3, tarefa.getStatus());
            ps.setDate(4, new java.sql.Date(tarefa.getDataConclusao().getTime()));

            ps.setInt(5, tarefa.getId());

            ps.execute();

            ps.close();
        } 
        catch (SQLException e) {
            System.out.println("Não foi possível atualizar a tarefa. Por favor tente novamente.");
        }
    }

    public void removerTarefa(Tarefa t)
    {
        String sql = "DELETE FROM tarefas WHERE id = ?";

        PreparedStatement ps = null;

        try 
        {
            ps = Conexao.getConexao().prepareStatement(sql);
            
            ps.setInt(1, t.getId());

            ps.execute();

            ps.close();

        } 
        catch (SQLException e) {
            System.out.println("Não foi possível remover a tarefa, por favor tente novament.");
        }
    }

    public Tarefa consultarTarefa(int id)
    {
        String sql = "SELECT tarefa.id, tarefa.descricao, tarefa.prioridade, tarefa.status, tarefa.dataConclusao " + "FROM tarefas WHERE id = ?";

        PreparedStatement ps = null;
        
        ResultSet rst = null;

        /*Fazer uma lista que retorne os dados e depois percorrer essa lista, porém mostrar
         * apenas a tarefa com o id específicado.
        */

        try 
        {
            
        } 
        catch (SQLException e) {
            System.out.println("Não foi possível consultar a tarefa.");
        }
    }

    public List<Tarefa> retornarTarefas()
    {
        String sql = "SELECT * FROM tarefas";

        List<Tarefa> tarefas = new ArrayList<>();

        PreparedStatement ps = null;

        ResultSet rst = null;

        try 
        {
            ps = Conexao.getConexao().prepareStatement(sql);

            rst = ps.executeQuery();

            while(rst.next())
            {
                Tarefa t = new Tarefa();

                t.setId(rst.getInt("id"));
                t.setDescricao(rst.getString("descricao"));
                t.setPrioridade(rst.getInt("prioridade"));
                t.setStatus(rst.getInt("status"));
                t.setDataConclusao(rst.getDate("dataConclusao"));

                tarefas.add(t);

                
            }

            rst.close();

            ps.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível retornar as tarefas.");
            return null;
        }

        return tarefas;

    }
}
