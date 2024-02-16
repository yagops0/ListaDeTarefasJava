package com.yagos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.DAO.TarefaDAO;
import com.classes.Tarefa;

/**
 * Hello world!
 *
 */


public class ListaDeTarefas 
{
    public static void main( String[] args)
    {
        Tarefa t = new Tarefa();
        ListaDeTarefas ldt = new ListaDeTarefas();
        //SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String dataS;
        Scanner ent = new Scanner(System.in);
        TarefaDAO td = new TarefaDAO();

        for(Tarefa tr : td.prioridadeFilter(1))
        {
            System.out.println("Desc: " + tr.getDescricao());
        }
        


    }


    private void linha()
    {
        System.out.println("==============================================================");
    }

    private void menu()
    {
        linha();
        System.out.println("1 - ");
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


