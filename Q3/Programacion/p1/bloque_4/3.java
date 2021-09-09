import java.util.*;

class b4_3 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		// Factores de conversion de  los metros
		double yardas=1.0936;
		double pulgadas=39.3701;
		double pies=3.2808;

		System.out.print("Selecciona entre Metros(m/M) y Centimetros (C/c)\n>> ");
		boolean cent = scan.next().equalsIgnoreCase("c");
		System.out.print("Introudce una cantidad a convertir\n>> ");
		double metros = scan.nextDouble();
		if(cent) metros /= 100;

		System.out.print("\n Selecciona a que lo quiere convertir:");
		System.out.print("\n1) A Yardas   ");
		System.out.print("\n2) A Pulgadas ");
		System.out.print("\n3) A Pies \n>> ");
		int conv = scan.nextInt();

		switch(conv){
			case 1:
				metros *= yardas;
				break;
			case 2:
				metros *= pulgadas;
				break;
			case 3:
				metros *= pies;
				break;
		}

		System.out.print("Tu cantidad convertida es >> "+metros);
	}
}
