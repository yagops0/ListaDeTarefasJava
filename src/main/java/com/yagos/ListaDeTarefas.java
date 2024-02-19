package com.yagos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.DAO.TarefaDAO;
import com.classes.Menus;
import com.classes.Tarefa;

/**
 * Hello world!
 *
 */


public class ListaDeTarefas 
{
    public static void main(String[] args)
    {
        Scanner ent = new Scanner(System.in);
        ListaDeTarefas ldt = new ListaDeTarefas();
        TarefaDAO td = new TarefaDAO();
        Tarefa t = new Tarefa();
        Menus menu = new Menus();
        int escolha, escolhaFiltros, escolhaPrioridade, escolhaStatus;
        char continuar;
        String data;

        ldt.espera();
        menu.linha();
        System.out.println("====================== LISTA DE TAREFAS ======================");
        menu.linha();
        ldt.espera();      
        
        try 
        {
            do
            {
                menu.menu();
                System.out.print("Digite o que deseja fazer: ");
                escolha = ent.nextInt();
                ent.nextLine();
                ldt.espera();
                menu.linha();

                switch(escolha)
                {
                    case 1:
                    {
                        ldt.espera();
                        System.out.println("= CRIAR TAREFA");
                        menu.linha();
                        ldt.espera();
                        System.out.print("Digite a descricao da tarefa: ");
                        t.setDescricao(ent.nextLine());
                        menu.linha();
                        ldt.espera();
                        System.out.print("Digite a prioridade da tarefa(0 - Normal/ 1 - Importante): ");
                        t.setPrioridade(ent.nextInt());
                        ent.nextLine();
                        menu.linha();
                        ldt.espera();
                        System.out.print("Digite o status da tarefa(0 - A iniciar / 1 - Em andamento / 2 - Concluída): ");
                        t.setStatus(ent.nextInt());
                        ent.nextLine();
                        menu.linha();
                        ldt.espera();
                        System.out.print("Digite a data de conclusão da tarefa(no formato aaaa/mm/dd): ");
                        data = ent.nextLine();
                        t.setDataConclusao(ldt.formatarData(data));
                        menu.linha();
                        ldt.espera();

                        td.cadastrarTarefa(t);

                        ldt.espera();
                        System.out.println("TAREFA CRIADA COM SUCESSO!");
                        menu.linha();
                        ldt.espera();
                        break;
                    }
                    case 2:
                    {

                        break;
                    }
                    case 3:
                    {

                        break;
                    }
                    case 4:
                    {

                        break;
                    }
                    case 5:
                    {

                        break;
                    }
                    case 6:
                    {

                        break;
                    }
                    default:
                    {
                        System.out.println("Por favor digite uma opção válida!");
                    }
                }
                
                System.out.println("Deseja continuar usando o programa(S/N)? ");
                continuar = ent.nextLine().charAt(0);

            }while(Character.toLowerCase(continuar) != 'n');
        } 
        catch (Exception e) {
            e.printStackTrace();        }
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

    private void espera()
    {
        try 
        {
            Thread.sleep(1000);
        } 
        catch (InterruptedException e) 
        {
           
            e.printStackTrace();
        }
    }
}


