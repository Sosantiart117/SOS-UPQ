import java.util.*;

class monedas {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		// Factores de conversion al 17 
		double euros=0.04;
		double dolares=0.05;
		double yenes=5.50;

		
		System.out.println("Introudce una cantidad en pesos");
		float pesos = scan.nextFloat();

		euros= pesos * euros;
		System.out.println("Euros\t:" + euros);

		dolares= pesos * dolares;
		System.out.println("Dolares\t:" + dolares);

		yenes= pesos * yenes;
		System.out.println("Yenes\t:" + yenes);
	}
}
