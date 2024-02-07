package com.yagos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.DAO.TarefaDAO;
import com.classes.Tarefa;

/**
 * Hello world!
 *
 */


public class ListaDeTarefas 
{
    public static void main( String[] args )
    {
        Tarefa t = new Tarefa();
        ListaDeTarefas ldt = new ListaDeTarefas();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date data = ldt.formatarData("2024/03/28");

        
        //t.setId(1);
        //t.setDescricao("Jogar lixo");
        //t.setPrioridade(1);
        //t.setStatus(2); 
        //t.setDataConclusao(data);

        t.setDescricao("Estudar");
        t.setPrioridade(0);
        t.setStatus(2);
        t.setDataConclusao(data);

        
       
        new TarefaDAO().cadastrarTarefa(t);
        

    }

    private Date formatarData(String data)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        try 
        {
            Date data1 = formato.parse(data);
            return data1;

        } 
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}


