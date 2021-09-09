/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author alira
 */
public class Uno {
    private static int metodo(){ // Metodo de clase privado si argumentos pero con retorno de tipo entero
        int valor=0; //Inicialiazamos la variable valor
        try{ //inicia nuestro manejo de excepciones
            valor=valor+1; // Al momento de tomar valor le agregamos 1 (valor = 1)
            valor=valor+Integer.parseInt("42"); /* A valor le agregamos "42" pero al momento de asignar
                                                  dicho valor usamos un string que estamos "convirtiendo" a
                                                  su valor entero; Aqui se puede generar una excepcion */
            valor=valor+1; // Le agregamos 1 (valor =44)
            System.out.println("Valor al final del try:"+valor); // Mostramos el valor de "valor" (valor = 44)
        }catch(NumberFormatException e){ /* Esta es la parte donde pretendemos "atrapar" una excepcion
                                        que pueda suceder por un "mal formato de numero" */ 
            valor=valor + Integer.parseInt("42"); /* En el caso de la excepcion generamos una misma
                                                     intancia donde le sumamos 42; (Valor = 43)*/
            System.out.println("Valor al final del catch:"+valor); /* Mostramos el valor de "valor", de ser la expcecion
                                                                    el valor sería 43*/
            // Como este código no genera esta excepcion este codigo nunca corre 
        }finally{ // Este código se ejecuta de cualquier manera 
            valor=valor+1; // Tomamos el valor "actual de valor" y le sumamos 1 (valor=45)
            System.out.println("Valor al final de finally:"+valor); // Mostramos el valor final de "valor"
        }
        //Este codigo se ejectua mientras no se genere un "runtime error"
        valor=valor+1; // Volvemos a sumarle 1 a valor (valor = 46)
        System.out.println("Valor antes del return:"+valor); //mostramos el ultimo valor de "valor"
        return valor; // Regresa el valor del entero "valor" en su estado ultimo
    }
    
    public static void main(String[]args){ //metodo main
        try{ //inicia nuestro manejo de excepciones
            System.out.println(metodo()); // Ejecutamos el metodo "metodo" y el valor de retorno lo mostramos
        }catch(Exception e){
            System.err.println("Excepcion en metodo()"); // Si se genera una excepcion generamos un mensaje.
            // Notese que solo se muestra si es una excepcion que no manejamos antes...
        }
    }
}
