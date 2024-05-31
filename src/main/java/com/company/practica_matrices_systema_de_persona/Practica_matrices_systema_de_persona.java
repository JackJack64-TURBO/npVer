/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.company.practica_matrices_systema_de_persona;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joubr
 */
public class Practica_matrices_systema_de_persona {
    static int cuentaCabesas = 0;
    
    public static void buscarEstudiante(personas[] lista){
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese el id del estudiante: ");
        int search = reader.nextInt();
        for(int i=0; i<lista.length; i++){
            if(lista[i].getId()==search){
                System.out.println("Estudiante encontrado.");
                System.out.println("Nombre: "+lista[i].getNombre());
                System.out.println("Carera: "+lista[i].getCarera());
                System.out.println("Edad: "+lista[i].getEdad());
                System.out.println("ID: "+lista[i].getId());
                printClases(lista, i+1);
                System.out.println("Promedio: "+lista[i].getPromedio());
                break;
            }
        }
    }
    
    public static void printClases(personas[] lista, int input){
        System.out.println("-----CLASES-----");
        String[] clases = lista[input-1].getClases();
        for(int i=0; i<clases.length; i++){
            System.out.println(i+1+") "+clases[i]);
        }
    }
    
    public static int[] eliminarClases(personas[] lista, int[] cantidad){
        Scanner readerInt = new Scanner(System.in);
        printList(lista);
        System.out.println("-------------------");
        System.out.println("Selecione al estudiante que quiera");
        int input = readerInt.nextInt();
        printClases(lista, input);
        System.out.println("selecione la clase que retirar para " + lista[input - 1].getNombre());
        int claseDlt = readerInt.nextInt();
        lista[input-1].setClases(null, claseDlt-1);
        printClases(lista, input);
        System.out.println("La clase fue retirada");
        cantidad[input-1]--;
        return cantidad;
    }
    
    public static int[] agregarClases(personas[] lista, int[] cantidad){
        Scanner readerInt = new Scanner(System.in);
        printList(lista);
        System.out.println("-------------------");
        System.out.println("Selecione al estudiante que quiera");
        int input = readerInt.nextInt();
        if(lista[input-1]==null){
            System.out.println("womb womb");
        }else if(cantidad[input-1]>4){
            System.out.println("Ya tiene el maximo de clases disponibles");
        }else{
            System.out.println("-------------------");
            System.out.println("selecione la clase para "+lista[input-1].getNombre());
            System.out.println("1 Quaso");
            System.out.println("2. uo que se");
            int clase = readerInt.nextInt();
            switch(clase){
                case 1-> lista[input-1].setClases("quaso", cantidad[input-1]);
                case 2-> lista[input-1].setClases("uo que es", cantidad[input-1]);
            }
            cantidad[input-1]++;
            printClases(lista, input);
        }
        
        return cantidad;
    }
    
    public static personas[] agregarAlumnos(personas[] lista){
        Scanner reader1 = new Scanner(System.in);
        Scanner reader2 = new Scanner(System.in);
        Scanner reader3 = new Scanner(System.in);
        Random ran = new Random();
        for(int i=cuentaCabesas; i<lista.length; i++){
            if(cuentaCabesas>21){
                System.out.println("Ya no hay mas cupo");
                break;
            }else{
                System.out.println("Ingrese el numbre del estudiante: ");
                String estudiante = reader1.nextLine();
                System.out.println("Ingrese la edad del estudiante: ");
                int edad = reader2.nextInt();
                System.out.println("ingrese la carrera del estudiante: ");
                String carrera = reader3.nextLine();
                int idFinal = ran.nextInt(1000, 9999);
                lista[i] = new personas(estudiante, edad, carrera, idFinal);
                cuentaCabesas++;
                System.out.println("Estudiante agregado, desea continuar? y o n");
                String input = reader2.next();
                if(input.equals("y")){
                    continue;
                }else if(input.equals("n")){
                    break;
                }else{
                    System.out.println("input no valido");
                }
            }
        }
        return lista;
    }
    
    public static void printList(personas[] lista){
        for(int i=0; i<lista.length; i++){
            System.out.println(i+1+") "+lista[i]);
        }
    }

    public static void main(String[] args) {
        Scanner readerStrng = new Scanner(System.in);
        Scanner readerInt = new Scanner(System.in);
        boolean exit = false;
        personas[] alumnos = new personas[21];
        int[] clasesPorAlmunos = new int[21];
        System.out.println("----REGISTRO DE ESTUDIANTES----");
        while(!exit){
            System.out.println("1. ver lista de estudiantes eregistrados");
            System.out.println("2. agregar estudiantes");
            System.out.println("3. asignar clases a los estudiantes");
            System.out.println("4. retirar clases a los estudiantes");
            System.out.println("5. buscar estudiante");
            System.out.println("6. atualisar informacion de los estudiantes");
            System.out.println("7. Salir");
            int input = readerInt.nextInt();
            
            switch(input){
                case 1->{
                    printList(alumnos);
                    System.out.println("-------------------");
                }
                
                case 2->{
                    System.out.println("-------------------");
                    alumnos = agregarAlumnos(alumnos);
                    System.out.println("-------------------");
                }
                
                case 3->{
                    System.out.println("-------------------");
                    agregarClases(alumnos, clasesPorAlmunos);
                    System.out.println("-------------------");
                }
                
                case 4->{
                    System.out.println("-------------------");
                    eliminarClases(alumnos, clasesPorAlmunos);
                    System.out.println("-------------------");
                    
                }
                
                case 5->{
                    System.out.println("-------------------");
                    buscarEstudiante(alumnos);
                    System.out.println("-------------------");
                }
                
                case 6->{
                    System.out.println("WIP");
                }
                
                case 7->{
                    System.out.println("-------------------");
                    System.out.println("byeeeee");
                    System.out.println("-------------------");
                    exit = true;
                }
                
                default ->{
                    System.out.println("-------------------");
                    System.out.println("Input no valido");
                    System.out.println("-------------------");
                }
            }
        }
    }
}
