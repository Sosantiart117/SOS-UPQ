// Author: SAntiago Orzoco Sanchez

import java.util.Scanner;

class cambio2 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		System.out.println("Introduzca un numbero (sin unidades o centavos) que desea pasar a billetes");
		float mon = scan.nextInt();

		// Billetes, 500, 200, 100, 50, 20
		short[] billetes = {500,200,100,50,20};

		// algoritmo
		// cambio = dinero % billete;
		// nbilletes = (dinero - cambio) / billete;
		
		// for(int i=0; i < billetes.length ; i++ ){

		// 	float num = mon / billetes[i];
		// 	float billete = (mon - num)/billetes[i];
		// 	mon = num;

		// 	// Salida 
		// 	System.out.println( billetes[i] + "\t|" + billete );
		// };
		//
		float num = mon % billetes[0];
		float foo = mon-num /billetes[0];
		System.out.println(foo);
	}
}
