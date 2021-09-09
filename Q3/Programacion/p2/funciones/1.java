import java.util.*;

class func1 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){

		// pow
		// llamar funcion
		// Sin Parametro
		int num;
		num = pow();
		System.out.println("Sin parametro: "+num);
		// Parametro
		num = pow(2,8);
		System.out.println("Con parametro: "+num);
	}

	static int pow(int numero, int potencia){
		int nNum = 1;
		for(int i =0 ; i< potencia; i++){
			nNum *= numero;
		}
		return nNum;
	}

	static int pow(){
		int nNum = 1;
		for(int i =0 ; i< 5; i++){
			nNum *= 10;
		}
		return nNum;
	}
}
