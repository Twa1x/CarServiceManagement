package com;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.sql.*;
import java.util.concurrent.ExecutionException;

public class DbFunctions {
    private ResultSet results = null;
    public Connection connect_to_db(String dbname, String user, String pass) {
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }


    public ResultSet getResults(Connection conn, String statement)
    {

        try
          {
              Statement localStatement;
             localStatement = conn.createStatement();
             results = localStatement.executeQuery(statement);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return results;

    }
    public void executeStatement(Connection conn, String statement)
    {
        try
        {
            Statement localStatement;
            localStatement = conn.createStatement();
            localStatement.executeUpdate(statement);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "There has been a database connection error - try again",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//end executeStatement method

}
