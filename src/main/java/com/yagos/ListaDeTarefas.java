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
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        t.setDescricao("Jogar lixo");
        t.setPrioridade(1);
        t.setStatus(2);
        
       
        new TarefaDAO().cadastrarTarefa(t);
        

    }
}
