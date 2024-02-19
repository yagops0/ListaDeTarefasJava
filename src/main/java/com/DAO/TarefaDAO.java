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

    public Tarefa consultarTarefa(int id1)
    {
        String sql = "SELECT *  FROM tarefas WHERE id = ?";

        PreparedStatement ps = null;
        
        ResultSet rst = null;

        Tarefa tar = new Tarefa();

        try 
        {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id1);

            rst = ps.executeQuery();

            if(rst.next())
            {
                tar.setId(rst.getInt("id"));
                tar.setDescricao(rst.getString("descricao"));
                tar.setPrioridade(rst.getInt("prioridade"));
                tar.setStatus(rst.getInt("status"));
                tar.setDataConclusao(rst.getDate("dataConclusao"));

                return tar;

            }
            else
            {
                return null;
            }

        } 
        catch (SQLException e) 
        {
           e.printStackTrace();
            return null;
        }
    }
    
    public List<Tarefa> prioridadeFilter(int filtroNum)
    {
        String sql = "SELECT * FROM tarefas WHERE prioridade = ?";
        PreparedStatement ps = null;
        ResultSet rst = null;
        

        List<Tarefa> priorFilter = new ArrayList<>(); 

        try 
        {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, filtroNum);

            rst = ps.executeQuery();

            if(filtroNum == 0)
            {
                while(rst.next())
                {
                    Tarefa t = new Tarefa();

                    t.setId(rst.getInt("id"));
                    t.setDescricao(rst.getString("descricao"));
                    t.setPrioridade(rst.getInt("prioridade"));
                    t.setStatus(rst.getInt("status"));
                    t.setDataConclusao(rst.getDate("dataConclusao"));

                    priorFilter.add(t);
                }

                return priorFilter;
            }
            else if(filtroNum == 1)
            {
                while(rst.next())
                {
                    Tarefa t = new Tarefa();

                    t.setId(rst.getInt("id"));
                    t.setDescricao(rst.getString("descricao"));
                    t.setPrioridade(rst.getInt("prioridade"));
                    t.setStatus(rst.getInt("status"));

                    priorFilter.add(t);

                }

                return priorFilter;
            }
            else
            {
                return null;
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally
        {
            try
            {
                rst.close();
                ps.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        
    }

    public List<Tarefa> statusFilter(int filtroNum)
    {
        String sql = "SELECT * FROM tarefas WHERE status = ?";

        PreparedStatement ps = null;

        ResultSet rst = null;

        List<Tarefa> statFilter = new ArrayList<>();

        try 
        {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, filtroNum);

            rst = ps.executeQuery();

            if(filtroNum == 0)
            {
                while(rst.next())
                {
                    Tarefa t = new Tarefa();

                    t.setId(rst.getInt("id"));
                    t.setDescricao(rst.getString("descricao"));
                    t.setPrioridade(rst.getInt("prioridade"));
                    t.setStatus(rst.getInt("status"));
                    t.setDataConclusao(rst.getDate("dataConclusao"));

                    statFilter.add(t);
                }
                
                return statFilter;
            }
            else if(filtroNum == 1)
            {
                while(rst.next()) 
                {
                    Tarefa t = new Tarefa();

                    t.setId(rst.getInt("id"));
                    t.setDescricao(rst.getString("descricao"));
                    t.setPrioridade(rst.getInt("prioridade"));
                    t.setStatus(rst.getInt("status"));
                    t.setDataConclusao(rst.getDate("dataConclusao"));

                    statFilter.add(t);
                }

                return statFilter;
            }
            else if(filtroNum == 2)
            {
                while(rst.next())
                {
                    Tarefa t = new Tarefa();

                    t.setId(rst.getInt("id"));
                    t.setDescricao(rst.getString("descricao"));
                    t.setPrioridade(rst.getInt("prioridade"));
                    t.setStatus(rst.getInt("status"));
                    t.setDataConclusao(rst.getDate("dataConclusao"));

                    statFilter.add(t);
                }

                return statFilter;
            }
            else
            {
                return null;
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            try 
            {
                rst.close();
                ps.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
            
        }

    }

    public List<Tarefa> dateFilter(int num)
    {
        List<Tarefa> listaTarefas = new ArrayList<>();

        PreparedStatement ps = null;

        ResultSet rst = null;

        try 
        {
            if(num == 0)
            {
                String sql = "SELECT * FROM tarefas ORDER BY dataConclusao ASC";

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

                    listaTarefas.add(t);
                }

                return listaTarefas;

            }
            else if(num == 1)
            {
                String sql = "SELECT * FROM tarefas ORDER BY dataConclusao DESC";

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

                    listaTarefas.add(t);
                }

                return listaTarefas;
            }
            else
            {
                return null;
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            try 
            {
                rst.close();
                ps.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }



}
