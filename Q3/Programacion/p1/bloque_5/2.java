import java.util.*;

class b5_2 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		int suma=0;
		double producto=1;
		//suma de 20 a 400
		for(int i=20; i<401;i+=2){
			suma+=i;
			System.out.print(i+(i==400?"":"+"));
		}
		System.out.print("="+suma+"\n");
		//producto de 20 a 400
		for(int i=20; i<401;i+=2){
			producto*=i;
			System.out.print(i+(i==400?"":"*"));
		}
		System.out.print("="+producto+"\n");
		// notese que el producto de los pares entre 20 y 400 es un numero demasiado grande como para almacenarse en cualquier tipo de dato primitivo
	}
}
