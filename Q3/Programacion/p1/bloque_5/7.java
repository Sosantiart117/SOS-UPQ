import java.util.*;

class b5_7 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		boolean first=true;
		System.out.print("Dame No de Filas:\n>>");
		int filas = scan.nextInt();
		System.out.print("Dame 2 numeros:\n>>");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();

		System.out.printf("|  %3d  ", num1);
		do{
			for(int i = 0; i<filas;i++){
				// ajustar fila si es el primer numero
				if(first) i++;
				first=false;

				// dejar en blanco si ya se acabao la serie pero quedan celdas pendientes
				if(num1==num2){
					System.out.print("|       "+((i+1)==filas?"|":""));
					continue;
				} 

				// Lógica de la secuencia ascendente o descendente
				if(num1 > num2) num1--;
				else num1++;
				System.out.printf("|  %3d  "+((i+1)==filas?"|":""), num1);
			}
			System.out.print("\n");
		}while(num1 != num2);
	}
}
