package com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao 
{
    private static String url = "jdbc:mysql://localhost:3306/listadetarefas";
    private static String user = "root";
    private static String password = "Yps_20050120";

    private static Connection conn;

    public static Connection getConexao()
    {
        try
        {
            if(conn == null)
            {
                conn = DriverManager.getConnection(url, user, password);

                return conn;
            }
            else
            {
                return conn;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
