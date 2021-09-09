import java.util.*;

class ex7 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		// dame coche
		System.out.print("Dame Modelo:");
		String modelo = scan.next();
		System.out.print("Es claro:(s/N)\n>> ");
		boolean esClaro = scan.next().equalsIgnoreCase("s");

		double precio = 0;

		switch(modelo){	
			case "A":
				if(esClaro) precio = 3800;
				else precio =  4500;
				break;
			case "B":
				if(esClaro) precio = 4950;
				else precio =  5600;
				break;
			case "C":
				if(esClaro) precio = 7800;
				else precio = 8300;
				break;
		}

		System.out.print("Dame edad:");
		int edad = scan.nextInt();

		if(edad>65) precio *= 1.15;
		else if(edad>30) precio *= 1;
		else if(edad>19) precio *= 1.1;
		else if(edad<19) precio *= 1.2;

		System.out.print("Dame años conduciendo:");
		int años = scan.nextInt();

		if(años<2) precio *= 1.25;

		System.out.print("\nEl costo de su seguro es:\n>> "+precio);
	}
}
