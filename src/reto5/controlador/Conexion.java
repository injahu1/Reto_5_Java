/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto5.controlador;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author Injah
 */
public class Conexion {
    
    private static Connection conect;
    

    
    public static void conectar() {

        String url = "jdbc:mysql://localhost:3306/reto5?serverTimezone=UTC";
        String user ="root";
        String ctr ="admin";

        try {

            conect = DriverManager.getConnection(url,user,ctr);
            JOptionPane.showMessageDialog (null , "Si conecta", "Base de datos",1); 
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog (null , "No conecta", "Base de datos",0); 
        }

    }

    public static void setConect(Connection conect) {
        Conexion.conect = conect;
    }

    public static Connection getConect() {
        return conect;
    }
    
    

    
}
