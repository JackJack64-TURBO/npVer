/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.practica_matrices_systema_de_persona;

/**
 *
 * @author joubr
 */
public class personas {
    //atributos
    private String nombre;
    private int edad;
    private String carera;
    private String[] clases;
    private double promedio;
    private int id;
    
    
    //constructor y metodos
    public personas(String nombre, int edad, String carera, int id) {
        this.nombre = nombre;
        this.edad = edad;
        this.carera = carera;
        this.clases = new String[5];
        this.promedio = 0.0;
        this.id = id;
    }
    
    //seters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCarera(String carera) {
        this.carera = carera;
    }

    public void setClases(String clases, int pos) {
        this.clases[pos] = clases;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //getters

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCarera() {
        return carera;
    }

    public String[] getClases() {
        return clases;
    }

    public double getPromedio() {
        return promedio;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", edad=" + edad + ", carera=" + carera + ", promedio=" + promedio + ", id=" + id ;
    }
    
    
    
    
    
}
