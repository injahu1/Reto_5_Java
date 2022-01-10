/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto5.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Injah
 */
public class Empleado {
    
     private int documento;
    private String nombre;
    private String telefono;
    private String direccion;
    private LocalDate fechaContrato;
    private ArrayList <Empleado> empleados;

    public Empleado(int documento, String nombre, String telefono, String direccion, LocalDate fechaContrato) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaContrato = fechaContrato;
        this.empleados = new ArrayList <Empleado>();
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public ArrayList<Empleado> getEmpleados() {
      //   empleados=new ArrayList<Empleado>();
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    
    
    @Override
    public String toString() {
        return "\n" + "Documento: " + documento + "\n" +"Nombre: " + nombre + "\n" +"Teléfono: " + telefono + "\n" +"Dirección: " + direccion + "\n" +"Fecha Contrato: " + fechaContrato + '\n';
    }
 
    
}
