import java.util.*;

class tablas {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		// Introducir las tablas
		System.out.print("Dime que tabla quieres ver: ");
		int tabla = scan.nextInt();
		System.out.print("\n¿Hasta que numero la quieres ver?: ");
		int lim = scan.nextInt();

		// tablas
		for (int i = 1; i <= lim; i++) 
			System.out.print("\n"+tabla +" x " +i +" = "+(tabla*i));

		System.out.print("\nGracias");
	}
}
