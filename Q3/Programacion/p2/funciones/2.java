import java.util.*;

class func2 {

	public static Scanner scan = new Scanner(System.in);

	static int num;

	public static void main(String[] args){
		// n^2 - 2*n

		System.out.print("Dame un numero: ");
		num = scan.nextInt();

		// llamar funcion
		// Sin Parametro
		int res = func();
		System.out.println("Sin parametro: "+res);
		// Parametro
		int resp = func(num);
		System.out.println("Con parametro: "+resp);
	}

	static int func(int n){
		return (int)Math.pow(n, 2) - (2*n);
	}

	static int func(){
		return (int)Math.pow(7, 2) - (2*7);
	}
}
