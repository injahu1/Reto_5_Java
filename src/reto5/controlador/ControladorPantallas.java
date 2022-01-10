/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto5.controlador;

import reto5.vista.Vreto5;

/**
 *
 * @author Injah
 */
public class ControladorPantallas {
    
    private static Vreto5 pantallaEmpleado;
    
    public static void abrirPantallaVreto5(){
        pantallaEmpleado=new Vreto5();
        pantallaEmpleado.setVisible(true);
        pantallaEmpleado.setLocationRelativeTo(null);
        
        
    }
    
        public static void cerrarPantallaVreto5(){
        //pantallaEmpleado=new Vreto4();
        pantallaEmpleado.setVisible(false);
        pantallaEmpleado=null;
        
        
    }
    
}
