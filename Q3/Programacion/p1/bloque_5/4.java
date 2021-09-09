import java.util.*;

class b5_4 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		// media
		System.out.print("Este programa hace la media de 50 numeros\n");
		int suma=0;
		for(int i = 0 ; i < 50; ++i){
			System.out.printf("Numero %2d: ",(i+1));
			suma += scan.nextInt();
		}
		double promedio= suma / 50;
		System.out.printf("El promedio es %5.2g", promedio);
	}
}
