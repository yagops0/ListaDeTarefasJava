package com.classes;

public class Menus 
{
    public void linha()
    {
        System.out.println("==============================================================");
    }

    public void menu()
    {
        System.out.println("1 - Criar tarefa");
        System.out.println("2 - Atualizar tarefa");
        System.out.println("3 - Consultar tarefa");
        System.out.println("4 - Filtragem de tarefas");
        System.out.println("5 - Listar tarefas");
        System.out.println("6 - Sair");
        linha();
    }

    public void menuFiltrar()
    {
        linha();
        System.out.println("1 - Filtragem por prioridade.");
        System.out.println("2 - Filtragem por status.");
        System.out.println("3 - Filtrar por tarefas mais velhas à mais recentes.");
        System.out.println("4 - Filtrar tarefas mais recentes para mais velhas");
        linha();
    }

    public void menuFiltrarPrioridade()
    {
        linha();
        System.out.println("0 - Ver tarefas com prioridade normal.");
        System.out.println("1 - Ver tarefas com prioridade importante.");
        linha();
    }

    public void menuFiltrarStatus()
    {
        linha();
        System.out.println("0 - Ver tarefas a iniciar.");
        System.out.println("1 - Ver tarefas em andamento.");
        System.out.println("2 - Ver tarefas concluídas.");
        linha();
    }

}
