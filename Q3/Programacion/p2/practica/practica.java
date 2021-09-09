import java.util.*;

class prac {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){

		// arreglos 
		// arreglo es una lista 
		// {dato,dato,dato,dato,dato,dato,dato,dato,dato,dato,dato,}
		// {0,		1,		2		3,	...															10}
		// int[] arreglo = 
		// int[] arreglo = {10,11,12,13,14,15,16};
		// int[] arreglo1 = new int[10];

		// int tamaño = arreglo.length;

		for(int i = 0; i<30;i++){
			int random = dameUnNumero(10*(i%2), i*i);
			System.out.printf("%n%d", random);
		}

		// int random2 = dameUnNumero(100, 200);
	}

	// dame un numero aleatorio dentro de un rango de numeros
	//
	static int dameUnNumero(int ini, int fin){
		// int num = ini+(int)(Math.random()*(fin-ini));
		// return num;
		return ini+(int)(Math.random()*(fin-ini));
	}
}
