/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto5.modelo;

import java.util.ArrayList;

/**
 *
 * @author Injah
 */
public class Semoviente {
    
     private int idSemoviente;
   private String raza;
   private String color;
   private String proposito;
   private Empleado empleado;
   private            ArrayList <Semoviente> semovientes ;

    public Semoviente(int idSemoviente, String raza, String color, String proposito, Empleado empleado) {
        this.idSemoviente = idSemoviente;
        this.raza = raza;
        this.color = color;
        this.proposito = proposito;
        this.empleado = empleado;
        this.semovientes = new ArrayList <Semoviente>();
        //this.semovientes=semovientes;
    }

    public int getIdSemoviente() {
        return idSemoviente;
    }

    public void setIdSemoviente(int idSemoviente) {
        this.idSemoviente = idSemoviente;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ArrayList<Semoviente> getSemovientes() {
        //semovientes=new ArrayList<Semoviente>();
        return semovientes;
    }

    public void setSemovientes(ArrayList<Semoviente> semovientes) {
        this.semovientes = semovientes;
    }

    @Override
    public String toString() {
        return "\n" + "Identificación:" + idSemoviente + "\n" +"Raza:" + raza + "\n" +"Color:" + color + "\n" +"Proposito:" + proposito + "\n" +"Encargado:" + empleado.getNombre()+"\n";
    }
    
}
