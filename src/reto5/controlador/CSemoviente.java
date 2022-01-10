
package reto5.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import reto5.modelo.Semoviente;

public class CSemoviente {

   // public static  ArrayList <Semoviente> puente = new ArrayList();
 
       public static Semoviente se=new Semoviente(00,"", "", "", CEmpleado.em);

    
    //ArrayList<Semoviente> semovientes, ArrayList<Empleado> empleados
         public static void registrarSemoviente( Integer iden,String raza, String colo, String prop, Integer enca, JTable Tabla) {

        boolean veriplaca=false;
        boolean verien=false;
        String cadena;
        String encargado="";


        se=new Semoviente(iden,raza, colo, prop, CEmpleado.em);
      //  se.setSemovientes(puente);
             
    if(iden>0){}
    else{
        JOptionPane.showMessageDialog (null , "¡No se puede completar la operación!\n\n Por favor ingrese identificación correcta ", "Error",0);
        return ;
    }
    
  try {
            
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs =st.executeQuery("select * from semoviente where ide_sem= '"+iden+"'");
           
            if (rs.next()){
            
            if(Integer.parseInt(rs.getString("ide_sem"))==iden){
            veriplaca=true;
    
            }}
            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "problemas al consultar");
            return;
            
        }
  
                 
               if(veriplaca==true){
                     
                   JOptionPane.showMessageDialog (null , "¡Semoviente ya existe!\n\n\n ", "Error",0);
                   return;
                }
                else{
       
                    
                    if(raza.equals("")||colo.equals("")){
                        
 JOptionPane.showMessageDialog (null , "¡Por favor diligenciar todos los campos!\n\n\n ", "Error",0);
 return;
                    }
                
                    if((prop.equals("Carne"))||(prop.equals("carne"))||(prop.equals("CARNE"))){
                        cadena="Carne";
                        }
                    else if (prop.equals("Leche")||(prop.equals("leche"))||(prop.equals("LECHE"))){
                        cadena="Leche";
                        }
                    else{
                         JOptionPane.showMessageDialog (null , "¡Propósito incorrecto!\n\n\n ", "Error",0);
                    return;
                    }
                    

  
    if(enca>0){}
    else{
        JOptionPane.showMessageDialog (null , "¡No se puede completar la operación!\n\n Encargado incorrecto ", "Error",0);
        return;
    }
               
           try {
            
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs =st.executeQuery("select * from empleado where doc_emp= '"+enca+"'");
           
            if (rs.next()){
            
            if(Integer.parseInt(rs.getString("doc_emp"))==enca){
             encargado=rs.getString("nom_emp");
           verien=true;
    
            }}
            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "problemas al consultar");
            return;
            
        }
         
         
         
        if(verien==true){
            
            
                      try {
            
            Statement st= Conexion.getConect().createStatement();
            st.execute("insert into semoviente values('"+iden+"','"+raza+"','"+colo+"','"+cadena+"' ,'"+encargado+"')");
            JOptionPane.showMessageDialog(null, "registro exitoso");
            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog (null , "¡Normandia!\n\nError de escritura", "Error",0); 
            return;
        }
              DefaultTableModel modelo= (DefaultTableModel) Tabla.getModel();
                        
                        modelo.setRowCount(0);
                        
                        

                          Object[] fila=new Object[5];
                      
                          fila[0]=iden;
                          fila[1]=raza;
                          fila[2]=colo;
                          fila[3]=cadena;
                          fila[4]=encargado;
                          modelo.addRow(fila);
          
       }     
        else{JOptionPane.showMessageDialog (null , "¡No existe ese empleado ", "Error",0);}
                }
 
    }

    public static void consultarSemoviente(Integer iden, JTable Tabla) {
        
          
  try {
            
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs =st.executeQuery("select * from semoviente where ide_sem= '"+iden+"'");
              DefaultTableModel modelo= (DefaultTableModel) Tabla.getModel();
           
            if (rs.next()){
            
            if(Integer.parseInt(rs.getString("ide_sem"))==iden){
            
                    modelo.setRowCount(0);
       
                Object[] fila={rs.getString("ide_sem"),rs.getString("raz_sem"),rs.getString("col_sem"),rs.getString("pro_sem"),rs.getString("nom_emp")};
                modelo.addRow(fila);
            
    
            }}
             else{
                     JOptionPane.showMessageDialog (null , "¡Normandia!\n\nSemoviente no existe! ", "Error",0); 
                     return;
                    
                }

            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "problemas al consultar");
            return;
            
        }
   
    }      
    
     public static void eliminarSemoviente(Integer iden, JTable Tabla) {
       try {
            
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs =st.executeQuery("select * from semoviente where ide_sem= '"+iden+"'");
              DefaultTableModel modelo= (DefaultTableModel) Tabla.getModel();
           
            if (rs.next()){
            
            if(Integer.parseInt(rs.getString("ide_sem"))==iden){
            
                    modelo.setRowCount(0);
       
                Object[] fila={rs.getString("ide_sem"),rs.getString("raz_sem"),rs.getString("col_sem"),rs.getString("pro_sem"),rs.getString("nom_emp")};
                st.execute("delete from semoviente where ide_sem= '"+iden+"'");
             JOptionPane.showMessageDialog(null, "Semoviente eliminado");
                modelo.addRow(fila);
            
    
            }}
             else{
                     JOptionPane.showMessageDialog (null , "¡Normandia!\n\nSemoviente no existe! ", "Error",0); 
                     return;
                    
                }

            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "problemas al consultar");
            return;
            
        }
    }

     
        public static void modificarSemoviente( Integer iden,String raza, String colo, String prop, Integer enca, JTable Tabla) {

  
        boolean veriplaca=false;
        boolean verien=false;
        String cadena;
        String encargado="";



        se=new Semoviente(iden,raza, colo, prop, CEmpleado.em);
     
             
    if(iden>0){}
    else{
        JOptionPane.showMessageDialog (null , "¡No se puede completar la operación!\n\n Por favor ingrese identificación correcta ", "Error",0);
        return ;
    }
    
  try {
            
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs =st.executeQuery("select * from semoviente where ide_sem= '"+iden+"'");
           
            if (rs.next()){
            
            if(Integer.parseInt(rs.getString("ide_sem"))==iden){
            veriplaca=true;
    
            }}
            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "problemas al consultar");
            return;
            
        }
  
                 
               if(veriplaca==true){
                   
                            if(raza.equals("")||colo.equals("")){
                        
 JOptionPane.showMessageDialog (null , "¡Por favor diligenciar todos los campos!\n\n\n ", "Error",0);
 return;
                    }
                
                    if((prop.equals("Carne"))||(prop.equals("carne"))||(prop.equals("CARNE"))){
                        cadena="Carne";
                        }
                    else if (prop.equals("Leche")||(prop.equals("leche"))||(prop.equals("LECHE"))){
                        cadena="Leche";
                        }
                    else{
                         JOptionPane.showMessageDialog (null , "¡Propósito incorrecto!\n\n\n ", "Error",0);
                    return;
                    }
                    
               
  
    if(enca>0){}
    else{//System.out.println("Ingreso incorrecto"); 
        JOptionPane.showMessageDialog (null , "¡No se puede completar la operación!\n\n Encargado incorrecto ", "Error",0);
        return;
    }
               
           try {
            
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs =st.executeQuery("select * from empleado where doc_emp= '"+enca+"'");
           
            if (rs.next()){
            
            if(Integer.parseInt(rs.getString("doc_emp"))==enca){
             encargado=rs.getString("nom_emp");
           verien=true;
    
            }}
            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "problemas al consultar");
            return;
            
        }
         
         
         
        if(verien==true){
            
            
                      try {
            
            Statement st= Conexion.getConect().createStatement();
            st.execute("update semoviente set  raz_sem='"+raza+"', col_sem='"+colo+"',pro_sem='"+cadena+"', nom_emp='"+encargado+"'  where ide_sem= '"+iden+"'");

            JOptionPane.showMessageDialog(null, "registro exitoso");
            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog (null , "¡Normandia!\n\nError de escritura", "Error",0); 
            return;
        }
              DefaultTableModel modelo= (DefaultTableModel) Tabla.getModel();
                        
                        modelo.setRowCount(0);
                        
                        

                          Object[] fila=new Object[5];
                      
                          fila[0]=iden;
                          fila[1]=raza;
                          fila[2]=colo;
                          fila[3]=cadena;
                          fila[4]=encargado;
                          modelo.addRow(fila);
          
       }     
        else{JOptionPane.showMessageDialog (null , "¡No existe ese empleado ", "Error",0);}
                     return;
                   
                }
                else{
         JOptionPane.showMessageDialog (null , "¡Semoviente no existe!\n\n\n ", "Error",0);
                   return;
           
                }
 
    }  
     
}

