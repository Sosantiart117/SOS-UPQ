import java.util.*;

class ciclo_anidado {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		// potencias 
		
		int numero, res=0, potencia;
		for (int i = 0; i < 4; i++){
			System.out.print("\nDame un numero: ");
			numero = scan.nextInt();
			res = numero;
			System.out.print("\nDame una potencia: ");
			potencia = scan.nextInt();
			
			for(int j = 1; j < potencia; j++) 
				res *= numero;

			System.out.print("\nSu cubo es: " + res);
		}
	}
}
