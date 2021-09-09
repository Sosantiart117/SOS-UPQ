import java.util.*;

class loops {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		// int rangoInicio, rangoFInal,  i, num;

		// System.out.println("Da un rango de numeros");
		// rangoInicio = scan.nextInt();
		// rangoFInal = scan.nextInt();

		// System.out.println("Ciclo while:");
		// i =0;
		// num=0;
		// while (num<=rangoFInal){
		// 	num = i+rangoInicio;
		// 	if(num%2==0) System.out.print(" "+ num+",");
		// 	i++;
		// }
		// i =0;
		// num=0;
		// System.out.println("\nAhora con un ciclo \"do\" while");
		// do{
		// 	num = i+rangoInicio;
		// 	if(num%2==0) System.out.print(" "+ num+",");
		// 	i++;
		// }while (num<rangoFInal);
		//
		// Ejercicio for

		int lim, num, pos=0, neg=0, cer=0;

		System.out.print("Cuantos numeros vas a introducir? ");
		lim = scan.nextInt();

		for (int i=0; i < lim; i++){
			System.out.print("\nNumero: ");
			num = scan.nextInt();

			if(num>0) pos++; 
			else if(num < 0) neg++;
			else cer++;
		}

		System.out.println("\nIngresaste "+pos+" numeros positivos"); 
		System.out.println("Ingresaste "+neg+" numeros negativos"); 
		System.out.println("Ingresaste "+cer+" ceros"); 

	}
}
