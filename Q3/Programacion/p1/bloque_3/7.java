import java.util.*;

class b3_7 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		//Elaborar un programa en C++ que solicite un número entre 1 y 20 y despliegue si es 
		System.out.print("Dame un numero entre 1 y 20: ");
		int num = scan.nextInt();

		// cacha numeros fuera de rango
		if(num > 20 || num < 1 ){
			System.out.print("Ese numerno no es entre 1 y 20");
			System.exit(1);
		}

		switch (num) {
			case 1:
			case 2:
			case 3:
			case 5:
			case 7:
			case 11:
			case 13:
			case 17:
				System.out.print("Es Primo!");
				break;
			default: 
				System.out.print("No es Primo!");
		}
	}
}
