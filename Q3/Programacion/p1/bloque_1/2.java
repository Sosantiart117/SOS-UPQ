// Author: SAntiago Orzoco Sanchez

import java.util.Scanner;

class cambio {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		System.out.println("Introduzca un numbero (sin unidades o centavos) que desea pasar a billetes");
		int num = scan.nextInt();

		// Billetes, 500, 200, 100, 50, 20

		// algoritmo
		// xbilletes = num / billete;
		// num = num % billete;
		
		// 500
		int quinientos = num / 500;
		num = num % 500;
		// 200
		int doscientos = num / 200;
		num = num % 200;
		// 100
		int cien = num / 100;
		num = num % 100;
		// 50
		int cincuenta = num / 50;
		num = num % 50;
		// 20
		int veinte = num / 20;
		num = num % 20;

		// Salida 
		System.out.println("\nSu cambio será (en billetes): " + quinientos+ " de 500, " + doscientos + " de 200, " + cien + " de 100, " + cincuenta+ " de 50, " + veinte+ " de 20, ");
		// Manejar moendas aunque se pide que no las meta...
		System.out.println("monedas de cambio... " +num);
		// por los enteros no maneja centavos
	}
}
