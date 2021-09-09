import java.util.*;
import java.lang.Math;

class ej1{
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){

		// primer ejercicio previo a la tarea
		float x=1,y=2,z=3;
		// primera operacion
		float w = (x+y+z)/2;
		System.out.println("Primera operacion: "+w);
		//Segunda operacion
		float w2 = (5-3)/(2*4);
		System.out.println("Segunda operacion: "+w2);

		// Ejercicio 1 ("chicharronera")
		System.out.println("\nFormula general para las ecuaciones de 2do grado:");
		System.out.print("\na: ");
		double a1 = scan.nextInt();
		System.out.print("\nb: ");
		double b1 = scan.nextInt();
		System.out.print("\nc: ");
		double c1 = scan.nextInt();
		// Mate
		double determinante = Math.sqrt(Math.pow(b1,2) + (4*a1*c1));
		double res1_1 = (b1 + determinante)/(2*a1);
		double res1_2 = (b1 - determinante)/(2*a1);
		System.out.println("Resultados:\nx_1 = "+res1_1 +"\nx_2 = "+res1_2);

		// Ejercicio 2
		System.out.println("\nIntroducir 2 variables: ('x' y 'y')");
		System.out.print("\nX: ");
		double x2 = scan.nextDouble();
		System.out.print("\nY: ");
		double y2 = scan.nextDouble();
		// Mate
		double res2 = ((3*x2)-(12*y2)+18)/3;
		System.out.println("El resultado es = "+res2);

		// Ejercicio 3
		System.out.println("\nPara el teorema de pitagoras introducir el valor de los catetos: (A y B)");
		System.out.print("\nA: ");
		double a3 = scan.nextDouble();
		System.out.print("\nB: ");
		double b3 = scan.nextDouble();
		//Mate
		double res3 = Math.pow(a3,2) + Math.pow(b3,2);
		System.out.println("El resultado es \nC^2= "+res3+"\nC= "+Math.sqrt(res3));


		// Ejercicio 4
		// Esta es otra opccion para la solucion
		// System.out.println("Ecuacion para las derivadas");
		// metotodo derivadas
		//
		// Solo sustituyendo
		System.out.println("\nEcuacion, incerte un valor para h,f y t:");
		System.out.print("\nh: ");
		double h4 = scan.nextDouble();
		System.out.print("\nf: ");
		double f4 = scan.nextDouble();
		System.out.print("\nt: ");
		double t4 = scan.nextDouble();
		//Mate
		double res4 = ((f4*(t4+h4))-(f4*t4))/h4;
		System.out.println("El resultado es: " + res4);


		// Ejercicio 5
		System.out.println("\nTeorema de la gravitacion universal:\n(Utilizando G=6.67x10^-11)");
		System.out.print("\nM_1, masa del objeto: ");
		double m5_1 = scan.nextDouble();
		System.out.print("\nM_2, Masa del objeto celeste: ");
		double m5_2 = scan.nextDouble();
		System.out.print("\nDistancia al centro del objeto: ");
		double r5 = scan.nextDouble();
		//Mate
		//Constante de gravitacion
		double g = 6.67e-11;
		double res5 = g*((m5_1 * m5_2)/Math.pow(r5,2));
		System.out.println("La fuerza de atraccion de un planeta: "+res5+"N");


		// Ejercicio 6
		System.out.println("\nPara la ecuacion de posicion de un objeto uniformemente acelerado necesitamos:");
		System.out.print("\nPosicion inicial: ");
		double x6 = scan.nextDouble();
		System.out.print("\nVelocidad Inicial: ");
		double v6 = scan.nextDouble();
		System.out.print("\nTiempo en el que se quiere saber la posicion: ");
		double t6 = scan.nextDouble();
		System.out.print("\nAceleracion: ");
		double a6 = scan.nextDouble();
		//Mate
		double res6 = x6 + (v6*t6) + ((.5)*a6*Math.pow(t6,2));
		System.out.println("Su posicion será: "+res6+"m");


		// Ejercicio 7
		System.out.println("\nTeorema de la gravitacion universal\nAplicado a 2 cuerpos que se atraen:\n(Utilizando G=6.67x10^-11)");
		System.out.print("\nPrimer Objeto: ");
		double m7_1 = scan.nextDouble();
		System.out.print("\nSegundo Objeto: ");
		double m7_2 = scan.nextDouble();
		System.out.print("\nDistancia entre objetos: ");
		double d7 = scan.nextDouble();
		//Mate
		//Constante de gdavitacion
		double res7 = g*((m7_1 * m7_2)/Math.pow(d7,2));
		System.out.println("La fuerza de atraccion entre los objetos: "+res7+"N");


		// Ejercicio 8
		System.out.println("\nNecesitamos a y b:");
		System.out.print("\nA: ");
		double a8 = scan.nextDouble();
		System.out.print("ahdahsdkjhaskdjhakjsd\nB: ");
		double b8 = scan.nextDouble();
		//Mate
		double res8 = (5*Math.pow(a8,2)*Math.pow(b8,3))+Math.sqrt(Math.pow(a8,2)+Math.pow(b8,2));
		System.out.println("El resultado es: "+res8);


		// Ejercicio 9
		System.out.println("\nNecesitamos a y b:");
		System.out.print("\nA: ");
		double a9 = scan.nextDouble();
		System.out.print("\nB: ");
		double b9 = scan.nextDouble();
		//Mate
		double res9 = Math.sqrt(4*a9*Math.pow(b9,2))+Math.pow((a9+b9),2);
		System.out.println("El resultado es: "+res9);
		

		// Ejercicio 10
		System.out.println("\nNecesitamos a , b y d:");
		System.out.print("\nA: ");
		double a10 = scan.nextDouble();
		System.out.print("\nB: ");
		double b10 = scan.nextDouble();
		System.out.print("\nD: ");
		double d10 = scan.nextDouble();
		//Mate
		double res10 = ((b10*Math.pow(a10,3))/(2*a10*Math.pow(b10,2)))-Math.sqrt(12*Math.pow(d10,4));
		System.out.println("El resultado es: "+res10);
	}
}
