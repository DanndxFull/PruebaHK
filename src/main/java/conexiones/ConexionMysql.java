/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Mauricio Torres Martinez
 */
//Class Singleton
public class ConexionMysql {
    //variable de clase
    public static ConexionMysql instance;//Singleton
    private Connection cnn;
    
    private String url = "jdbc:mysql://localhost:3306/bd_tallerjavaweb?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String user = "root";
    private String password = "";
    
    private ConexionMysql(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error1 "+ex.getMessage());
        }
        
    }
    
    public static synchronized ConexionMysql getInstance(){
        if(instance==null){
          instance = new ConexionMysql();
        }
        
        return instance;
    }

    public Connection getCnn() {
        return cnn;
    }

    public void CerrarConexion(){
        instance = null;
    }
    
    
    
}
