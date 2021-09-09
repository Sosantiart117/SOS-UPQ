import java.util.*;

class ulam{
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		// dame un numerpo 
		System.out.print("Dame un numero sos-kun \n>> ");
		ulam(scan.nextInt());
	}

	static void ulam(int num){
		// \------- Caso base
		if(num == 1) return;

		int res;
		// algoritmo ulam
			if(num%2==0){
				res = num/2;
			}else{
				res = (num*3)+1;
			}
		// muestra los pasos
		System.out.println(res);

		// has la recursividad 
		ulam(res);
	}
}
