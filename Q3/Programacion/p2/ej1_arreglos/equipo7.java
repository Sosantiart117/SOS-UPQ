import java.util.*;

class nombres {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){

		//Captura el tamaño del arreglo
		System.out.print("Digite el numero de nombres que desea ingresar: \n>> ");
		int size = scan.nextInt();

		// arreglo nombres
		String[] nombres = new String[size];
		// Arreglo longotudes
		int[] longitudes = new int[size];

		// llenar el arreglo de nombres
		for(int i = 0; i < size; i++){
			System.out.printf("Dame el nombre %d: \n>> ", i+1);
			nombres[i] = scan.next();
			// Popular el segundo arreglo 
			longitudes[i] = nombres[i].length();
		}

		// Mostrar todo
		// for(int i = 0; i < size; i++) {
		// 	System.out.printf("\nEl nombre %2d es: %10s con longitud:%2d", i+1, nombres[i],longitudes[i]);
		// }

		// Version sin el segundo arreglo 
		for(int i = 0; i < size; i++) {
			System.out.printf("\nEl nombre %2d es: %10s con longitud:%2d", i+1, nombres[i],nombres[i].length());
		}
	}
}
