/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Supeshala
 */
public class DBConection {
    
    private static final String host = "jdbc:mysql://localhost:3306/medical lab";
    private static final String user = "root";
    private static final String password = "";
    
    private static Connection connection;

    public DBConection() {
    }
    
    public static Connection getConnection(){
        if(connection == null){
            try{
               connection = (Connection) DriverManager.getConnection(host,user,password);
               System.out.println("Connected............");
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    public static void closeConnection(){
        if(connection != null){
            try{
               connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
