import java.util.*;

class b5_5 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		int num, suma=0, pares=0, impares=0;
		double promedio=1;
		System.out.print("Introdusca 10 numero:\n");
		for(int i=0; i < 10; i++){
			System.out.printf("Numero %d:",(i+1));
			num = scan.nextInt();
			if(num%2==0){
				suma+=num;
				pares++;
			}else{
				promedio+=num;
				impares++;
			}
		}
		promedio/=impares;
		System.out.printf("\nIntrodujo:\n\nNo.Pares: %13d\nY su suma es: %9d\n",pares,suma);
		System.out.printf("\nNo.Impares: %11d\nY su promedio es: %5.2f",impares,promedio);
	}
}
