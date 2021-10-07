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
    
    private String url = "jdbc:postgresql://ec2-34-205-14-168.compute-1.amazonaws.com:5432/dbkfet9l0e3top?sslmode=require";
    private String user = "malqoycdayuetc";
    private String password = "46840f1341b8f8ee3a3d857fdd6bb3168eba1e68dcad2235dcdfc992241518d9";
    
    private ConexionMysql(){
        try {
            Class.forName("org.postgresql.Driver");
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
