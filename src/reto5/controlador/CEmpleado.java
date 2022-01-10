/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto5.controlador;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import reto5.modelo.Empleado;

/**
 *
 * @author Injah
 */
public class CEmpleado {
    //public static  ArrayList <Empleado> empleados = new ArrayList();
    //public static  ArrayList <Empleado> puente2 = new ArrayList();
    public static LocalDate f=LocalDate.now();
      public static Empleado em=new Empleado(0, "", "", "", f);

    
     public static void registrarEmpleado(Integer docu,String nomb, String tele, String dire, String fech , JTable Tabla) {

   
        boolean veriplaca=false; 
        LocalDate fecha=LocalDate.now();
        //Empleado 
        em=new Empleado(docu, nomb, tele, dire, fecha);

  
    if(docu>0){}
    else{ JOptionPane.showMessageDialog (null , "¡No se puede completar la operación!\n\n Por favor ingrese documento valido  ", "Error",0); 
    return;}

 try {
            
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs =st.executeQuery("select * from empleado where doc_emp= '"+docu+"'");
           
            if (rs.next()){
            
            if(Integer.parseInt(rs.getString("doc_emp"))==docu){
            veriplaca=true;
    
            }}
      
          
            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "problemas al consultar");
            return;
            
        }
  

                 
               if(veriplaca==true){
                    JOptionPane.showMessageDialog (null , "¡Normandia!\n\nEmpleado ya existe! ", "Error",0); 
                    return;
                }
                else{
          if(nomb.equals("")||tele.equals("")||dire.equals("")){
                        
 JOptionPane.showMessageDialog (null , "¡Por favor diligenciar todos los campos!\n\n\n ", "Error",0);
 return;
                    }
                    
                    //System.out.println("Ingrese la fecha de contrato del empleado (AAAA-MM-DD): ");  
                    try{fecha=LocalDate.parse(fech);
                    
                    }
                    catch(Exception g){
                       JOptionPane.showMessageDialog (null , "¡Normandia!\n\nFecha incorrecta", "Error",0); 
                       return;}
                    
                    
                     try {
            
            Statement st= Conexion.getConect().createStatement();
            st.execute("insert into empleado values('"+docu+"','"+nomb+"','"+tele+"','"+dire+"' ,'"+fecha+"')");
            JOptionPane.showMessageDialog(null, "registro exitoso");
            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog (null , "¡Normandia!\n\nError de escritura", "Error",0); 
            return;
        }
                    


                  
                   DefaultTableModel modelo= (DefaultTableModel) Tabla.getModel();
                        
                        modelo.setRowCount(0);
                        
                        

                          Object[] fila=new Object[5];
                      
                          fila[0]=docu;
                          fila[1]=nomb;
                          fila[2]=tele;
                          fila[3]=dire;
                          fila[4]=fecha;
                          modelo.addRow(fila);
                  
                  
                  
                        }
              
               
    }
    
       public static void consultarEmpleado(Integer docu,JTable Tabla) {
       boolean veriplaca=false;

          
          try {
            
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs =st.executeQuery("select * from empleado where doc_emp= '"+docu+"'");
                         DefaultTableModel modelo= (DefaultTableModel) Tabla.getModel();

            
            
            if (rs.next()){
            
            if(Integer.parseInt(rs.getString("doc_emp"))==docu){
            veriplaca=true;
            
                        modelo.setRowCount(0);
       
                Object[] fila={rs.getString("doc_emp"),rs.getString("nom_emp"),rs.getString("tel_emp"),rs.getString("dir_emp"),rs.getString("fec_emp")};
                modelo.addRow(fila);
            
                    
    
            }}
            else{
                     JOptionPane.showMessageDialog (null , "¡Normandia!\n\nEmpleado no existe! ", "Error",0); 
                     return;
                    
                }

            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "problemas al consultar");
            return;
            
        }
  
          
     
    }  
    
        public static void eliminarEmpleado(Integer docu,JTable Tabla) {
        
             
             
             try {
                 
                 Statement st = Conexion.getConect().createStatement();
                 ResultSet rs =st.executeQuery("select * from empleado where doc_emp= '"+docu+"'");
                 DefaultTableModel modelo= (DefaultTableModel) Tabla.getModel();
                 
                 
                 
                 if (rs.next()){
                     
                     if(Integer.parseInt(rs.getString("doc_emp"))==docu){
                       
                         
                         modelo.setRowCount(0);
                         
                         Object[] fila={rs.getString("doc_emp"),rs.getString("nom_emp"),rs.getString("tel_emp"),rs.getString("dir_emp"),rs.getString("fec_emp")}; 
                         st.execute("delete from empleado where doc_emp= '"+docu+"'");
             JOptionPane.showMessageDialog(null, "Empleado eliminado");
                         modelo.addRow(fila);
                     }}
                 else{
                     JOptionPane.showMessageDialog (null , "¡Normandia!\n\nEmpleado no existe! ", "Error",0);
                     return;
                     
                 }
                 
                 
             } catch (SQLException ex) {
                 Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "problemas al consultar");
                 return;
                 
             }
             
      
    }
        
        public static void modificarEmpleado(Integer docu,String nomb, String tele, String dire, String fech , JTable Tabla){
            
            
          boolean veriplaca=false; 
        LocalDate fecha=LocalDate.now();
        //Empleado 
        em=new Empleado(docu, nomb, tele, dire, fecha);

  
    if(docu>0){}
    else{ JOptionPane.showMessageDialog (null , "¡No se puede completar la operación!\n\n Por favor ingrese documento valido  ", "Error",0); 
    return;}

 try {
            
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs =st.executeQuery("select * from empleado where doc_emp= '"+docu+"'");
           
            if (rs.next()){
            
            if(Integer.parseInt(rs.getString("doc_emp"))==docu){
            veriplaca=true;
    
            }}

        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "problemas al consultar");
            return;
            
        }
  
       
               if(veriplaca==true){
                   
                   if(nomb.equals("")||tele.equals("")||dire.equals("")){
                        
 JOptionPane.showMessageDialog (null , "¡Por favor diligenciar todos los campos!\n\n\n ", "Error",0);
 return;
                    }
                    
                    //System.out.println("Ingrese la fecha de contrato del empleado (AAAA-MM-DD): ");  
                    try{fecha=LocalDate.parse(fech);
                    
                    }
                    catch(Exception g){
                       JOptionPane.showMessageDialog (null , "¡Normandia!\n\nFecha incorrecta", "Error",0); 
                       return;}
                    
                    
                     try {
            
            Statement st= Conexion.getConect().createStatement();
            st.execute("update empleado set  nom_emp='"+nomb+"', tel_emp='"+tele+"',dir_emp='"+dire+"', fec_emp='"+fecha+"'  where doc_emp= '"+docu+"'");

            JOptionPane.showMessageDialog(null, "registro exitoso");
            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog (null , "¡Normandia!\n\nError de escritura", "Error",0); 
            return;
        }
                    

                  
                   DefaultTableModel modelo= (DefaultTableModel) Tabla.getModel();
                        
                        modelo.setRowCount(0);

                          Object[] fila=new Object[5];
                      
                          fila[0]=docu;
                          fila[1]=nomb;
                          fila[2]=tele;
                          fila[3]=dire;
                          fila[4]=fecha;
                          modelo.addRow(fila);
                  
                   
                    
                }
                else{
          
                  JOptionPane.showMessageDialog (null , "¡Normandia!\n\nEmpleado no existe! ", "Error",0); 
                    return;
                  
                        }
              
            
        }
       
}


