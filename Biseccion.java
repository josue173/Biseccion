package com.mycompany.biseccion;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class Biseccion {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Double> resultados = new ArrayList<>();
    static ArrayList<Double> evaluaciones = new ArrayList<>();
    static ArrayList<Double> errores = new ArrayList<>();
    
    public static void main(String[] args) {
         System.out.println("Ingrese el valor inicial: ");
         double inicio = scan.nextDouble();
         System.out.println("Ingrese el valor final: ");
         double fin = scan.nextDouble();
         iterar(inicio, fin);
         mostrar();
         //double resultado = iterar(inicio, fin);
         //System.out.println("Resultado:  " + resultado );
         
    }
    
    public static void iterar(double inicio, double fin){
        double promedio = 0;
        double errorRelativo =1;
        double error =0.0005;
        
        //System.out.println(funcion(promedio));
        //while(Math.abs(funcion(promedio))>error){ 
        while(errorRelativo>error){ 
            errorRelativo = 0.0;
            promedio= (inicio+fin)/2;
            //System.out.println("Promedio: " + (promedio));
            if(funcion(inicio)*funcion(promedio)<0){ 
                // Se multiplica la evaluación del incio y el promedio, si da negativo (<0) hubo cambio, de lo contrario no
                errorRelativo = Math.abs(fin-promedio);
                //System.out.println("Error relativo 1: " +errorRelativo);
                fin = promedio; 
                
            } else {
                errorRelativo = Math.abs(inicio-promedio);
                //System.out.println("Error relativo 2: " +errorRelativo);
                inicio = promedio;
                // Si no hay un cambio en inicio*promedio, lo hay en fin*promedio, entonces mi incio = promedio
                // MI INICIO Y FIN CAMBIARÁN CONFORME PASE ESTE CÓDIGO
            }
            resultados.add(promedio);
            evaluaciones.add(funcion(promedio));
            errores.add(errorRelativo);
        }
        // return promedio;
    }
    
    public static double funcion(double x){
        return  3*Math.pow(x,2) - Math.pow(Math.E, x) + 7; // 3x^2 - e^x + 7
    }

    public static void mostrar() {
    System.out.println("Iteracion\tEvaluacion\t\t\tError relativo\t\tPromedio");
    for (int i = 0; i < resultados.size(); i++) {
        System.out.println((i + 1) + "\t\t" + evaluaciones.get(i) + "\t\t" + errores.get(i)+ "\t\t\t" + resultados.get(i));
    }
}


}