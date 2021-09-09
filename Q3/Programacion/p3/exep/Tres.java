/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author alira
 */
public class Tres {
  public static void main(String[] args) { // Nuestro Método main
    Scanner sc = new Scanner(System.in); // Implementa un Scanner para hacer la entrada de datos
    int n; // Declaramos n sin asignarle un valor 
    try{ // Empezamos con nuestro manejo de excepciones
      do{ // Empiza un ciclo do while
          System.out.print("Introduce un número entero > 0: "); // Le decimos al usuario que introduzca un valor
          n = sc.nextInt(); // Leemos el valor que introdujo
          System.out.println("Número introducido: " + n); // Mostramos el valor que introdujo
      }while(n<=0); // en el caso de que el numero sea negativo volvemos a iterar
    }catch (InputMismatchException ex){ // Aqui atrapamos la excepcion 
      System.out.println("Debe introducir un número"+ ex.getMessage()); // Mostramos el mensaje de la excepcion
      // esta excepcion solo nos va a aparecer en el caso de que el numero introducido no sea Numero
    }
  }
}
